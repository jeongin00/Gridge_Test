package com.risingcamp.grittest.controller.admin.log.dto;

import com.risingcamp.grittest.repository.admin.post.entity.PostHistory;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostHistoryResponseDto {
    private Integer id;

    private String nickname;
    private PostStatus beforeStatus;
    private PostStatus afterStatus;
    private String reason;
    private String adminLoginId;
    private LocalDateTime createdAt;

    public static PostHistoryResponseDto from(PostHistory entity) {
        return new PostHistoryResponseDto(
                entity.getId(),
                entity.getNickname(),
                entity.getBeforeStatus(),
                entity.getAfterStatus(),
                entity.getReason(),
                entity.getAdminLoginId(),
                entity.getCreatedAt()
        );
    }
}
