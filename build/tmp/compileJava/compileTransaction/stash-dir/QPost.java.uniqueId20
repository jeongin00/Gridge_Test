package com.risingcamp.grittest.repository.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 951102485L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final ListPath<com.risingcamp.grittest.repository.comment.entity.Comment, com.risingcamp.grittest.repository.comment.entity.QComment> comments = this.<com.risingcamp.grittest.repository.comment.entity.Comment, com.risingcamp.grittest.repository.comment.entity.QComment>createList("comments", com.risingcamp.grittest.repository.comment.entity.Comment.class, com.risingcamp.grittest.repository.comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final com.risingcamp.grittest.repository.user.entity.QUser createdBy;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<com.risingcamp.grittest.repository.like.entity.Like, com.risingcamp.grittest.repository.like.entity.QLike> likes = this.<com.risingcamp.grittest.repository.like.entity.Like, com.risingcamp.grittest.repository.like.entity.QLike>createList("likes", com.risingcamp.grittest.repository.like.entity.Like.class, com.risingcamp.grittest.repository.like.entity.QLike.class, PathInits.DIRECT2);

    public final ListPath<com.risingcamp.grittest.repository.postImedia.entity.PostMedia, com.risingcamp.grittest.repository.postImedia.entity.QPostMedia> postMedia = this.<com.risingcamp.grittest.repository.postImedia.entity.PostMedia, com.risingcamp.grittest.repository.postImedia.entity.QPostMedia>createList("postMedia", com.risingcamp.grittest.repository.postImedia.entity.PostMedia.class, com.risingcamp.grittest.repository.postImedia.entity.QPostMedia.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final com.risingcamp.grittest.repository.user.entity.QUser updatedBy;

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.risingcamp.grittest.repository.user.entity.QUser(forProperty("createdBy")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new com.risingcamp.grittest.repository.user.entity.QUser(forProperty("updatedBy")) : null;
    }

}

