package com.risingcamp.grittest.controller.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Schema(description = "회원가입을 위한 정보들")
@Setter
public class SingUpRequestDto {
    @Schema(description = "유저아이디", example = "hji1234")
    private String loginId;
    @Schema(description = "전화번호", example = "01012345678")
    @NotNull(message = "전화번호를 입력해주세요")
    private String phone;
    @Schema(description = "유저이름", example = "홍길동")
    private String name;
    @Schema(description = "닉네임", example = "고추냉이")
    private String nickname;
    @Schema(description = "비밀번호", example = "qwe123")
    @NotNull(message = "비밀번호를 입력해주세요")
    private String password;
    @Schema(description = "개인정보동의서", example = "true")
    private boolean termsAgreed;
}
