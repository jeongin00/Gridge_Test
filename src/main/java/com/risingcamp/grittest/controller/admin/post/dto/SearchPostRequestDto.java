package com.risingcamp.grittest.controller.admin.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SearchPostRequestDto {
    @NotNull(message = "pageIndex가 필요합니다.")
    @Schema(description = "페이지 수", example = "0")
    private Integer pageIndex;
    @NotNull(message = "size가 필요합니다.")
    @Schema(description = "게시글 수", example = "1")
    @Min(value = 1, message = "최소 게시글은 1개 이상입니다.")
    private Integer size;
    @Schema(description = "아이디", example = "qwe123")
    @Nullable
    private String loginId;
    @Schema(description = "포스트상태")
    @Nullable
    private PostStatus postStatus;
    @Nullable
    @Schema(description = "포스트 생성일자", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
