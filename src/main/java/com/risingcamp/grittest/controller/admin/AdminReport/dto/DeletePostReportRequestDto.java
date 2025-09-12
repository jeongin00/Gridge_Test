package com.risingcamp.grittest.controller.admin.AdminReport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeletePostReportRequestDto {
    @Schema(description = "신고 삭제이유", example = "신고내용과 일치하지않습니다.")
    private String reason;
}
