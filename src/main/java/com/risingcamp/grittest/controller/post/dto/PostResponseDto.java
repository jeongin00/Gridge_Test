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
public class PostResponseDto {
    @Schema(description = "포스트 아이디", example = "1")
    private Integer id;
    @Schema(description = "글 내용", example = "유저가 입력했던 글")
    private String content;
    @Schema(description = "작성일", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Schema(description = "작성자")
    private UserSimpleResponseDto createdBy;
    @Schema(description = "좋아요 수", example = "5")
    private long likesCount;  // 좋아요 수만 가져올거라서 service 에서 처리하기
    @Schema(description = "게시글에 첨부된 이미지,동영상 목록", example = "[{\n" +
            "    \"mediaUrl\" : \"http://google.com/cat.jpg\",\n" +
            "    \"mediaType\" : \"IMAGE\"    \n" +
            "},{\n" +
            "    \"mediaUrl\" : \"http://google.com/catvideo.mp4\",\n" +
            "        \"mediaType\" : \"VIDEO\"\n" +
            "        }\n" +
            "        ]")
    private List<PostMediaResponseDto> postMedia;

    public static PostResponseDto from(Post entity, long likesCount){
        List<PostMediaResponseDto> mediaResponseDto = entity.getPostMedia()
                .stream()
                .map(PostMediaResponseDto::from)
                .toList();
        return new PostResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedAt(),
                UserSimpleResponseDto.from(entity.getCreatedBy()),
                likesCount,
                mediaResponseDto
        );
    }
}