package com.risingcamp.grittest.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.controller.user.dto.UserSimpleResponseDto;
import com.risingcamp.grittest.repository.post.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostCreateResponseDto {
    @Schema(description = "포스트 아이디", example = "1")
    private Integer id;
    @Schema(description = "글 내용", example = "유저가작성한 글내용")
    private String content;
    @Schema(description = "작성일", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Schema(description = "작성자")
    private UserSimpleResponseDto createdBy;

    @Schema(description = "미디어응답리스트목록", example = "[\n" +
            "        {\n" +
            "            \"id\" : \"1\",\n" +
            "            \"mediaUrl\" : \"http://google.com/cat.jpg\",\n" +
            "            \"mediaType\" : \"IMAGE\",\n" +
            "            \"postId\" : \"3\"\n" +
            "        },\n" +
            "        {\n" +
            "        \"id\" : \"2\",\n" +
            "        \"mediaUrl\" : \"http://google.com/cat.mp4\",\n" +
            "        \"mediaType\" : \"VIDEO\",\n" +
            "        \"postId\" : \"4\"\n" +
            "        }\n" +
            "        ]")
    private List<PostMediaResponseDto> postMedia;

    public static PostCreateResponseDto from(Post entity){
        List<PostMediaResponseDto> mediaDto = entity.getPostMedia()
                .stream()
                .map(PostMediaResponseDto::from)
                .toList();
        return new PostCreateResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedAt(),
                UserSimpleResponseDto.from(entity.getCreatedBy()),
                mediaDto
        );
    }
}