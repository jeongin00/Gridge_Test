package com.risingcamp.grittest.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.controller.user.dto.UserSimpleResponseDto;
import com.risingcamp.grittest.repository.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostCreateResponseDto {
    private Integer id;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private UserSimpleResponseDto createdBy;

    /*
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private UserSimpleResponseDto updatedBy;
    */


    private List<PostMediaResponseDto> postMedia;

    public static PostCreateResponseDto from(Post entity){
        return new PostCreateResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedAt(),
                UserSimpleResponseDto.from(entity.getCreatedBy()),
                Collections.emptyList()
        );
    }
}