package com.risingcamp.grittest.security;

import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userRepository;
    public static final String AUTHORITIES_KEY = "roles";

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Collection<? extends GrantedAuthority> getAuthoritiesFromToken(Claims claims) {
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .toList();
        return authorities;
    }

    @Override
    // JwtParser.parse method can throw below exception, so you should catch and do something.
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(((JwtAuthenticationToken) authentication).getToken())
                    .getPayload();
        } catch (SignatureException signatureException) {
            // SignatureException – if a JWS signature was discovered, but could not be verified. JWTs that fail signature validation should not be trusted and should be discarded.
            String error = "signature key is different";
            log.error(error, signatureException);
            throw new JwtInvalidException(error, signatureException);
        } catch (ExpiredJwtException expiredJwtException) {
            // ExpiredJwtException – if the specified JWT is a Claims JWT and the Claims has an expiration time before the time this method is invoked.
            String error = "expired token";
            log.error(error, expiredJwtException);
            throw new JwtInvalidException(error, expiredJwtException);
        } catch (MalformedJwtException malformedJwtException) {
            // MalformedJwtException – if the specified JWT was incorrectly constructed (and therefore invalid). Invalid JWTs should not be trusted and should be discarded.
            String error = "malformed token";
            log.error(error, malformedJwtException);
            throw new JwtInvalidException(error, malformedJwtException);
        } catch (IllegalArgumentException illegalArgumentException) {
            // IllegalArgumentException – if the specified string is null or empty or only whitespace.
            String error = "using illegal argument like null";
            log.error(error, illegalArgumentException);
            throw new JwtInvalidException(error, illegalArgumentException);
        }

        String subject = claims.getSubject(); // 유저 ID가 문자열로 저장돼 있음
        Integer userId = Integer.parseInt(subject);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new JwtInvalidException("토큰 내 사용자 정보가 존재하지 않습니다."));

        return new JwtAuthenticationToken(user, getAuthoritiesFromToken(claims));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

