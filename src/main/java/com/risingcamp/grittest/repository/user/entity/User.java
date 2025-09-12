package com.risingcamp.grittest.repository.user.entity;

import com.risingcamp.grittest.repository.user.entity.vo.Source;
import com.risingcamp.grittest.security.vo.OAuth2Resource;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String loginId;   //  아이디(1~20자)

    private String phone;

    private String name;  // 본명
    
    private String nickname; // 닉네임
    @Setter
    private String password; // 비밀번호

    private Source source;  // 소셜로그인인지 로컬인지
    private String providerId; // 소셜 고유 ID

    private LocalDateTime createdAt;  // 회원가입 시점

    @Setter
    private Boolean termsAgreed;    // 개인정보 동의
    @Setter
    private LocalDateTime termsAgreedAt;  // 개인정보 동의 시점

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus userStatus;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @Override
    public String getUsername() {
        return this.loginId;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userType == UserType.ADMIN ? ADMIN_ROLES : SIMPLE_ROLES;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Transient
    private List<SimpleGrantedAuthority> authorities = SIMPLE_ROLES;
    public final static SimpleGrantedAuthority ROLE_USER = new SimpleGrantedAuthority("ROLE_USER");
    public final static SimpleGrantedAuthority ROLE_ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
    public final static List<SimpleGrantedAuthority> SIMPLE_ROLES = List.of(ROLE_USER);
    public final static List<SimpleGrantedAuthority> ADMIN_ROLES = List.of(ROLE_USER, ROLE_ADMIN);


    public static User create(OAuth2Resource resource) {
        return new User(
                null,
                null,
                null,
                null,
                null,
                null,
                resource.getProvider(), // KAKAO
                resource.getProviderId().toString(),
                LocalDateTime.now(),
                null, // 개인정보동의서 Null
                LocalDateTime.now(),
                UserStatus.ACTIVE,
                UserType.USER,
                SIMPLE_ROLES  // USER, ADMIN
        );
    }
    public static User create(String loginId, String phone,  String name, String nickname, String password, Boolean termsAgreed){
        return new User(
                null,
                loginId,
                phone,
                name,
                nickname,
                password,
                Source.HOMEPAGE,
                null,
                LocalDateTime.now(), // 회원가입 시점
                termsAgreed,
                LocalDateTime.now(), // termsAgreedAt
                UserStatus.ACTIVE,
                UserType.USER,
                SIMPLE_ROLES
        );
    }

    public static User createAdmin(String loginId, String phone,  String name, String nickname, String password, Boolean termsAgreed){
        return new User(
                null,
                loginId,
                phone,
                name,
                nickname,
                password,
                Source.HOMEPAGE,
                null,
                LocalDateTime.now(), // 회원가입 시점
                termsAgreed,
                LocalDateTime.now(), // termsAgreedAt
                UserStatus.ACTIVE,
                UserType.ADMIN,
                ADMIN_ROLES
        );
    }
}




