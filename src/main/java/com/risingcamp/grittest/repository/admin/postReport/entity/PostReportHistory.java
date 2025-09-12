package com.risingcamp.grittest.repository.admin.postReport.entity;

import com.risingcamp.grittest.repository.postReport.entity.PostReportStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickname;
    private PostReportStatus beforeStatus;
    private PostReportStatus afterStatus;
    private String reason;
    private String adminLoginId;
    private LocalDateTime createdAt;

    public static PostReportHistory create(String nickname, PostReportStatus beforeStatus, PostReportStatus afterStatus, String reason, String adminLoginId) {
        return new PostReportHistory(
                null,
                nickname,
                beforeStatus,
                afterStatus,
                reason,
                adminLoginId,
                LocalDateTime.now()
        );
    }
}

