package com.risingcamp.grittest.repository.postImedia.entity;

import com.risingcamp.grittest.repository.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String mediaUrl;
    private MediaType mediaType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    public static PostMedia create(String mediaUrl,MediaType mediaType ,Post post){
        return new PostMedia(
                null,
                mediaUrl,
                mediaType,
                post
        );
    }

}
