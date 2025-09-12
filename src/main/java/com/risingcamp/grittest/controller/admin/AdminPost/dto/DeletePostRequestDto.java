package com.risingcamp.grittest.controller.admin.AdminPost.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeletePostRequestDto {
    @Schema(description = "게시물 삭제이유", example = "부적절한 이미지사용")
    private String reason;
}
