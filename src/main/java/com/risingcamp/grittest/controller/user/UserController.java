package com.risingcamp.grittest.controller.user;

import com.risingcamp.grittest.controller.user.dto.ResetPasswordRequestDto;
import com.risingcamp.grittest.repository.user.UserRepository;
import com.risingcamp.grittest.repository.user.entity.User;
import com.risingcamp.grittest.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "Users", description = "유저에 관련된 작업들")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @PatchMapping("/resetpassword")
    @Operation(summary = "비밀번호 변경", description = "전화번호 인증을 통해 비밀번호를 변경합니다.")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDto request){
        userService.resetPassword(request);
        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
    }

    @PatchMapping("/reagree")
    @Operation(summary = "개인정보 동의서 재확인", description = "1년뒤에 개인정보처리 재동의를 해줍니다.")
    public ResponseEntity<String> reAgreeTerms(@AuthenticationPrincipal User user){
        userService.reAgreeTerms(user.getId());  //
        return ResponseEntity.ok("개인정보처리 동의가 갱신되었습니다.");
    }
}
// 매일 11시에 배치 돌려라 (스케쥴러)