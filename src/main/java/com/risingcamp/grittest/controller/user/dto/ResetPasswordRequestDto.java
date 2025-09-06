package com.risingcamp.grittest.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestDto {

    @Schema(description = "전화번호", example = "01012345678")
    @NotNull(message = "전화번호를 입력해주세요")
    private String phone;
    @Schema(description = "새로운비밀번호", example = "123qwe")
    private String newPassword;
}
