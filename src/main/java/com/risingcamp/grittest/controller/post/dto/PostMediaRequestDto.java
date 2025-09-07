package com.risingcamp.grittest.controller.post.dto;

import com.risingcamp.grittest.repository.postImedia.entity.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMediaRequestDto {
    private String mediaUrl;
    private MediaType mediaType;
}
