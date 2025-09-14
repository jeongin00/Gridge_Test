package com.risingcamp.grittest.controller.admin.user;

import com.risingcamp.grittest.controller.admin.user.dto.*;
import com.risingcamp.grittest.controller.auth.dto.LoginRequestDto;
import com.risingcamp.grittest.controller.auth.dto.SingUpRequestDto;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.service.AdminService;
import com.risingcamp.grittest.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
@Tag(name = "Admin User", description = "관리자의 User관련 작업들")
public class AdminUserController {
    private final AuthService authService;
    private final AdminService adminService;

    // admin 생성 도메인
    //@Secured("ROLE_ADMIN")
    @PostMapping("/signup")
    @Operation(summary = "관리자 회원가입", description = "홈페이지 회원가입만 가능합니다.")
    public ResponseEntity<String> create(@RequestBody AdminSingUpRequestDto request) {
        authService.adminSignup(request);
        return ResponseEntity.ok("관리자 회원가입 성공");
    }


    @PostMapping("/login")
    @Operation(summary = "로그인", description = "홈페이지 로그인만 가능합니다.")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequestDto request) {
        String token = authService.adminLogin(request);
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body("관리자 로그인 성공");
    }

    // User 조회도메인
    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public ResponseEntity<List<SearchUserResponseDto>> findByAll(@RequestBody @Valid SearchUserRequestDto request) {
        List<SearchUserResponseDto> users = adminService.findUsers(request);
        return ResponseEntity.ok(users);
    }

    // User 수정도메인(유저 상태수정 blocked같은)
    @Secured("ROLE_ADMIN")
    @PutMapping("{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Integer id, @RequestBody UpdateUserRequestDto request, @AuthenticationPrincipal User user) {
        adminService.update(id, request, user);
        return ResponseEntity.ok("정상적으로 업데이트 됐습니다.");
    }


    // User 삭제도메인
    @Secured("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody DeleteUserRequestDto request, @AuthenticationPrincipal User user) {
        adminService.userDelete(id, request, user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}


