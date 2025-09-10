package com.risingcamp.grittest.controller.post.dto;

import com.risingcamp.grittest.repository.postImedia.entity.MediaType;
import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMediaResponseDto {
    @Schema(description = "미디어 아이디", example = "1")
    private Integer id;
    @Schema(description = "미디어 주소", example = "http://google.com/cat.jpg")
    private String mediaUrl;
    @Schema(description = "미디어 타입", example = "IMAGE")
    private MediaType mediaType;
    @Schema(description = "포스트 아이디", example = "2")
    private Integer postId;
    public static PostMediaResponseDto from(PostMedia entity){
        return new PostMediaResponseDto(
                entity.getId(),
                entity.getMediaUrl(),
                entity.getMediaType(),
                entity.getPost().getId()
        );
    }
}
