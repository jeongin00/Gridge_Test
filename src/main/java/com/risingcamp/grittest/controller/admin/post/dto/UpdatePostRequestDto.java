package com.risingcamp.grittest.controller.admin.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePostRequestDto {
    @Schema(description = "포스트상태변경이유", example = "다수의 신고가 접수됨 보류")
    private String reason;
}
