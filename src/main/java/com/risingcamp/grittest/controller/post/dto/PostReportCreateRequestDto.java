package com.risingcamp.grittest.controller.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostReportCreateRequestDto {
    @Schema(description = "신고제목", example = "욕설")
    private String title;
    @Schema(description = "신고내용", example = "욕이 너무 심해용")
    private String content;
}
