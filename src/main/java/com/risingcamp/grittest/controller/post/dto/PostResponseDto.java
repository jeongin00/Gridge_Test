/*
package com.risingcamp.grittest.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.controller.user.dto.UserResponseDto;
import com.risingcamp.grittest.controller.user.dto.UserSimpleResponseDto;
import com.risingcamp.grittest.repository.post.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDto {
    private Integer id;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private UserSimpleResponseDto createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private UserSimpleResponseDto updatedBy;

    private int likeCount;  // 좋아요 수만 가져올거라서 service 에서 처리하기

    private List<PostMediaResponseDto> postMedia;

    public static PostResponseDto from(Post post, int likeCount){
        return new PostResponseDto(
                post.getId(),
                post.getContent(),
                post.
        )
    }
}
*/