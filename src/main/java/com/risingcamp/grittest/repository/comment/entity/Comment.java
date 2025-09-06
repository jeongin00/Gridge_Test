package com.risingcamp.grittest.repository.comment.entity;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String content;  // 코멘트내용

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by")
    private User updatedBy;
    private LocalDateTime updatedAt;

    public static Comment create(String content, Post post, User user){
        return new Comment(
                null,
                content,
                post,
                user,
                LocalDateTime.now(),
                user,
                LocalDateTime.now()
        );
    }

}
