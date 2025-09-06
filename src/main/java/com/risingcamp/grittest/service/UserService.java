package com.risingcamp.grittest.service;

import com.risingcamp.grittest.controller.user.dto.ResetPasswordRequestDto;
import com.risingcamp.grittest.exception.BaseException;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Override  // Spring Security가 자동으로 401 응답을 처리 Exception 적용X 코드 바꾸면 안됨
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저입니다 - phone : " + loginId));
        return user;
    }

    @Transactional
    public void resetPassword(ResetPasswordRequestDto request){
        User user = userRepository.findByPhone(request.getPhone())
                .orElseThrow(()->new BaseException(HttpStatus.NOT_FOUND,"데이터베이스내 유저가 존재하지 않습니다"));
        String encodedPassword = passwordEncoder.encode(request.getNewPassword());
        user.setPassword(encodedPassword);
    }

    @Transactional
    @Scheduled (cron = "0 0 2 * * *")
    public void expiredTerms(){
        LocalDateTime now = LocalDateTime.now();
        List<User> users = userRepository.findAll()
                .stream()
                .filter(user -> user.getTermsAgreedAt().plusYears(1).isBefore(now))
                .filter(user -> user.getTermsAgreed()) // true 인경우에만 통과시김
                .toList();  // 1년이 지나고 동의 상태인 애들만 담아놓음

        users.stream()
                .forEach(user -> user.setTermsAgreed(false));
    }

    @Transactional
    public void reAgreeTerms(Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new BaseException(HttpStatus.NOT_FOUND,"데이터베이스내 유저가 존재하지 않습니다."));
        user.setTermsAgreed(true);
        user.setTermsAgreedAt(LocalDateTime.now());
    }
}