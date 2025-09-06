package com.risingcamp.grittest.service;

import com.risingcamp.grittest.controller.auth.dto.LoginRequestDto;
import com.risingcamp.grittest.controller.auth.dto.SingUpRequestDto;
import com.risingcamp.grittest.exception.BaseException;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.repository.user.entity.UserStatus;
import com.risingcamp.grittest.repository.user.entity.vo.Source;
import com.risingcamp.grittest.security.JwtProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Transactional
    public void signup(SingUpRequestDto request){
        if(userRepository.existsByLoginId(request.getLoginId())){
            throw new BaseException(HttpStatus.CONFLICT,"이미 존재하는 아이디입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword()); // 회원가입할 때 그냥 평문으로 DB에 넣으면 안됨

        User user = User.create(
                request.getLoginId(),
                request.getPhone(),
                request.getName(),
                request.getNickname(),
                encodedPassword,
                request.isTermsAgreed()
        );

        if(user.getTermsAgreedAt().isBefore(LocalDateTime.now().minusYears(1))){
            throw new BaseException(HttpStatus.FORBIDDEN,"개인정보 재동의가 필요합니다.");
        }
        userRepository.save(user);
    }

    @Transactional
    public String login(LoginRequestDto request) {
        String loginId = request.getLoginId();
        User user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND,"데이터베이스 내 유저가 존재하지 않습니다. phone : " + loginId));
        // 소셜 로그인 확인 로직
        if(request.getSource() == Source.KAKAO){
            throw new BaseException(HttpStatus.UNAUTHORIZED, "소셜 로그인 유저는 카카오로 로그인해주세요");
        }
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BaseException(HttpStatus.UNAUTHORIZED,"비밀번호가 틀렸습니다.");
        }

        // 유저의 계정 상태에 따라 로그인 성공 여부를 반환
        if (user.getUserStatus() != UserStatus.ACTIVE) {
            throw new BaseException(HttpStatus.FORBIDDEN,"정상승인 되지 않은 계정입니다." + user.getUserStatus());
        }

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user.getId(), null, user.getAuthorities());

        return jwtProvider.generate(authentication);
    }
}
