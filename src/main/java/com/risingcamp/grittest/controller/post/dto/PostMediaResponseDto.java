package com.risingcamp.grittest.controller.post.dto;

import com.risingcamp.grittest.repository.postImedia.entity.MediaType;
import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMediaResponseDto {
    private Integer id;
    private String mediaUrl;
    private MediaType mediaType;
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
