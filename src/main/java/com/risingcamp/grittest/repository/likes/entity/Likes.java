package com.risingcamp.grittest.repository.likes.entity;

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
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;
    private LocalDateTime createdAt;  // 좋아요 누른 시간


    public static Likes create(Post post, User user){
        return new Likes(
                null,
                post,
                user,
                LocalDateTime.now()
        );
    }


}

