package com.risingcamp.grittest.repository.post.entity;

import com.risingcamp.grittest.repository.likes.entity.Likes;
import com.risingcamp.grittest.repository.postImedia.entity.PostMedia;
import com.risingcamp.grittest.repository.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by")
    private User updatedBy;  // 관리자가 수정할 수 있으니 따로 분리
    private LocalDateTime updatedAt;

    private PostStatus postStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PostMedia> postMedia = new ArrayList<>();

    public static Post create(String content, User user){
        return new Post(
                null,
                content,
                user,
                LocalDateTime.now(),
                user,
                LocalDateTime.now(),
                PostStatus.VISIBLE,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

}
