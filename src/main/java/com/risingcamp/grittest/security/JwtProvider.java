package com.risingcamp.grittest.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider implements InitializingBean {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.expiration}")
    private long expiration;

    private SecretKey key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    
    // 인증이 완료된 사용자의 정보를 받아 JWT 토큰을 생성 후 String으로 반환해서 클라이언트에게 넘겨줌
    public String generate(Authentication authentication) {
        String username = authentication.getName();
//      User user = authentication.getPrincipal();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + (expiration * 1000));
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .subject(username)
//              .claim("id", user.getId())
//              .claim("name", user.getName())
                .claim(JwtAuthenticationProvider.AUTHORITIES_KEY, authorities)
                .signWith(key)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .compact();
    }
}

