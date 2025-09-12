package com.risingcamp.grittest.controller.admin.AdminLog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostHistoryRequestDto {
    @NotNull(message = "pageIndex가 필요합니다.")
    @Schema(description = "페이지 수" , example = "0")
    private Integer pageIndex;
    @NotNull(message = "size가 필요합니다.")
    @Schema(description = "게시글 수" , example = "1")
    @Min(value = 1, message = "최소 게시글은 1개 이상입니다.")
    private Integer size;
}
