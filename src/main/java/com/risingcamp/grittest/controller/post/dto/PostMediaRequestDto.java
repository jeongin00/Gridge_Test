package com.risingcamp.grittest.controller.post.dto;

import com.risingcamp.grittest.repository.postImedia.entity.MediaType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostMediaRequestDto {
    @Schema(description = "미디어 주소", example = "http://google.com/cat.jpg")
    private String mediaUrl;
    @Schema(description = "미디어 타입", example = "IMAGE")
    private MediaType mediaType;
}
