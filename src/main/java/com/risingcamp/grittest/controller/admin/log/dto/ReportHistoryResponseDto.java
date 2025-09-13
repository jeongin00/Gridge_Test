package com.risingcamp.grittest.controller.admin.log.dto;

import com.risingcamp.grittest.repository.admin.postReport.entity.PostReportHistory;
import com.risingcamp.grittest.repository.postReport.entity.PostReportStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReportHistoryResponseDto {
    private Integer id;

    private String nickname;
    private PostReportStatus beforeStatus;
    private PostReportStatus afterStatus;
    private String reason;
    private String adminLoginId;
    private LocalDateTime createdAt;


    public static ReportHistoryResponseDto from(PostReportHistory entity) {
        return new ReportHistoryResponseDto(
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
