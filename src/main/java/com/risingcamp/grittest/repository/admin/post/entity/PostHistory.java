package com.risingcamp.grittest.repository.admin.post.entity;

import com.risingcamp.grittest.repository.post.entity.Post;
import com.risingcamp.grittest.repository.post.entity.PostStatus;
import com.risingcamp.grittest.repository.user.entity.UserStatus;
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
public class PostHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickname;
    private PostStatus beforeStatus;
    private PostStatus afterStatus;
    private String reason;
    private String adminLoginId;
    private LocalDateTime createdAt;
    public static PostHistory create(String nickname, PostStatus beforeStatus, PostStatus afterStatus, String reason, String adminLoginId){
        return new PostHistory(
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
