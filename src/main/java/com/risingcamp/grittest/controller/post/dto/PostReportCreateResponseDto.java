package com.risingcamp.grittest.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.repository.postReport.entity.PostReport;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostReportCreateResponseDto {
    @Schema(description = "포스트리포트 아이디", example = "1")
    private Integer id;
    @Schema(description = "포스트아이디", example = "1")
    private Integer postId;
    @Schema(description = "작성일", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Schema(description = "유저아이디", example = "1")
    private Integer userId;
    @Schema(description = "신고제목", example = "욕설")
    private String title;
    @Schema(description = "신고내용", example = "욕이 너무 심해용")
    private String content;

    public static PostReportCreateResponseDto from(PostReport entity){
        return new PostReportCreateResponseDto(
                entity.getId(),
                entity.getPost().getId(),
                entity.getCreatedAt(),
                entity.getCreatedBy().getId(),
                entity.getTitle(),
                entity.getContent()
        );
    }
}
