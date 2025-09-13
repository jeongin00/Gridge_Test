package com.risingcamp.grittest.controller.admin.log.dto;

import com.risingcamp.grittest.repository.admin.user.entity.UserHistory;
import com.risingcamp.grittest.repository.user.entity.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserHistoryResponseDto {

    private Integer id;

    private String nickname;
    private UserStatus beforeStatus;
    private UserStatus afterStatus;
    private String reason;
    private String adminLoginId; // 조치한 관리자id
    private LocalDateTime createdAt;

    public static UserHistoryResponseDto from(UserHistory entity) {
        return new UserHistoryResponseDto(
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
