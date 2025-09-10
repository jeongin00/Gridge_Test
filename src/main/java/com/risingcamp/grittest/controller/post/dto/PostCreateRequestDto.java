package com.risingcamp.grittest.controller.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostCreateRequestDto {
    @Schema(description = "글 내용", example = "유저가 입력했던 글 내용")
    private String content;
    @Schema(description = "미디어주소,미디어타입 리스트 목록", example = "[\n" +
            "        {\n" +
            "        \"mediaUrl\" : \"http://google.com/cat.jpg\",\n" +
            "        \"mediaType\" : \"IMAGE\"\n" +
            "        },\n" +
            "        {\n" +
            "        \"mediaUrl\" : \"http://google.com/cat.mp4\",\n" +
            "        \"mediaType\" : \"VIDEO\"\n" +
            "        }\n" +
            "        ]")
    List<PostMediaRequestDto> postMedias;
}

