package com.risingcamp.grittest.controller.auth.dto;

import com.risingcamp.grittest.repository.user.entity.vo.Source;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    @Schema(description = "로그인 방식", example = "HOMEPAGE")
    @NotNull(message = "로그인 방식을 입력해주세요")
    private Source source; // HOMEPAGE , KAKAO
    @Schema(description = "유저아이디", example = "hji1234")
    private String loginId;
    @Schema(description = "비밀번호", example = "qwe123")
    @NotNull(message = "비밀번호를 입력해주세요")
    private String password;
}
