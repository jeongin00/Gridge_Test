package com.risingcamp.grittest.controller.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostCreateRequestDto {
    private String content;
    List<PostMediaRequestDto> postMedias;
}
