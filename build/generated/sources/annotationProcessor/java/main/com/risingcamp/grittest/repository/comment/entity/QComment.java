package com.risingcamp.grittest.repository.comment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -1234214629L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final com.risingcamp.grittest.repository.user.entity.QUser createdBy;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.risingcamp.grittest.repository.post.entity.QPost post;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final com.risingcamp.grittest.repository.user.entity.QUser updatedBy;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.risingcamp.grittest.repository.user.entity.QUser(forProperty("createdBy")) : null;
        this.post = inits.isInitialized("post") ? new com.risingcamp.grittest.repository.post.entity.QPost(forProperty("post"), inits.get("post")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new com.risingcamp.grittest.repository.user.entity.QUser(forProperty("updatedBy")) : null;
    }

}

