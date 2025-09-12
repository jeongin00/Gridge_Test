package com.risingcamp.grittest.controller.admin.AdminUser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserRequestDto {
    @Schema(description = "업데이트이유", example = "규정을 어겼습니다.")
    private String reason;
}
