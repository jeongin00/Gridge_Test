package com.risingcamp.grittest.repository.user;

import com.risingcamp.grittest.repository.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByPhone(String phone);
    Optional<User> findByProviderId(String providerId);
    boolean existsByLoginId(String loginId); // 회원가입 중복 체크용
}


//org.springframework.security.core.userdetails.User 는 보안용이라 entity에서 사용 불가!