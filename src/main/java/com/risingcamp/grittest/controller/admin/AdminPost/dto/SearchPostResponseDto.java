package com.risingcamp.grittest.controller.admin.AdminPost.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class SearchPostResponseDto {
    @Schema(description = "포스트아이디")
    private Integer id;
    @Schema(description = "포스트 글")
    private String content;
    @Schema(description = "작성유저아이디")
    private String loginId;
    @Schema(description = "포스트상태")
    private PostStatus postStatus;
    @Schema(description = "포스트작성 일자" , example = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public static SearchPostResponseDto from(Post entity){
        return new SearchPostResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedBy().getLoginId(),
                entity.getPostStatus(),
                entity.getCreatedAt()
        );
    }


}
