package com.risingcamp.grittest.security;

import com.risingcamp.grittest.repository.user.entity.User;
import lombok.Getter;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;


@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken{
        private User principal;    // userId 안쓰고 user 쓸거라서 수정 강사님과 다른 방법
        private String credentials;

        public String getToken() {
            return this.credentials;
        }

        // 1. AuthenticationFilter 에서 가장 처음 인증정보를 담아 최초 JwtAuthenticationToken 생성
        public JwtAuthenticationToken(String token) {
            super(null);
            this.credentials = token;
            super.setAuthenticated(false);
        }

        // 2. AuthenticationProvider 에서 인증정보 일치여부를 판단한 뒤 최종 JwtAuthenticationToken 생성 (후에 SecurityContextHolder 내 저장할것)
        public JwtAuthenticationToken(User user, Collection<? extends GrantedAuthority> authorities) {
            super(authorities);
            this.principal = user;
            super.setAuthenticated(true);
        }
    }
