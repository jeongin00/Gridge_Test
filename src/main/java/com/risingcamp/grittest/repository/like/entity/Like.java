package com.risingcamp.grittest.repository.like.entity;

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
public class Like {
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


    public static Like create(Post post, User user){
        return new Like(
                null,
                post,
                user,
                LocalDateTime.now()
        );
    }


}
