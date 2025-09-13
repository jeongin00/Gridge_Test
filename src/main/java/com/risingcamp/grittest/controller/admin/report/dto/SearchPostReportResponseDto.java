package com.risingcamp.grittest.controller.admin.report.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.controller.post.dto.PostCreateResponseDto;
import com.risingcamp.grittest.repository.postReport.entity.PostReport;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SearchPostReportResponseDto {

    @Schema(description = "신고아이디")
    private Integer postReportId;
    @Schema(description = "신고 제목")
    private String title;
    @Schema(description = "신고 내용")
    private String content;
    @Schema(description = "신고자닉네임")
    private String nickname;
    @Schema(description = "신고시기", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private PostCreateResponseDto post;

    public static SearchPostReportResponseDto from(PostReport entity) {
        PostCreateResponseDto post = PostCreateResponseDto.from(entity.getPost());
        return new SearchPostReportResponseDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedBy().getNickname(),
                entity.getCreatedAt(),
                post
        );
    }
}
