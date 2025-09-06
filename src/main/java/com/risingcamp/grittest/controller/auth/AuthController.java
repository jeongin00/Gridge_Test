package com.risingcamp.grittest.controller.auth;

import com.risingcamp.grittest.controller.auth.dto.LoginRequestDto;
import com.risingcamp.grittest.controller.auth.dto.SingUpRequestDto;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.repository.user.entity.vo.Source;
import com.risingcamp.grittest.security.JwtProvider;
import com.risingcamp.grittest.security.vo.OAuth2UserDetails;
import com.risingcamp.grittest.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.Assigned;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Auth", description = "jwt 토큰을 사용한 회원가입 및 로그인")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "Jwt 토큰을 활용한 회원가입입니다.")
    public ResponseEntity<String> signup(@RequestBody SingUpRequestDto request) {
        authService.signup(request);
        return ResponseEntity.ok("회원가입 성공");
    }


    @PostMapping("/login")
    @Operation(summary = "로그인", description = "Jwt 토큰을 활용한 로그인입니다.")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
        String token = authService.login(request); // 로그인 성공 시 JWT 리턴
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body("로그인 성공");
    }

}


