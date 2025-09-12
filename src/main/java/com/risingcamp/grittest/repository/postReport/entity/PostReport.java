package com.risingcamp.grittest.repository.postReport.entity;

import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 일단 postId 피요
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PostReport")
    private Post post;
    // 신고 제목 필요
    private String title;
    // 신고 내용 필요
    private String content;
    // 신고한 유저 필요
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;
    private LocalDateTime createdAt;
    private PostReportStatus postReportStatus;

    public static PostReport create(Post post, String title, String content, User user){
        return new PostReport(
                null,
                post,
                title,
                content,
                user,
                LocalDateTime.now(),
                PostReportStatus.ACTIVE
        );
    }
}
