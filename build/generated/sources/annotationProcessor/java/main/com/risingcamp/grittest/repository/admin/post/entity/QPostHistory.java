package com.risingcamp.grittest.repository.admin.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostHistory is a Querydsl query type for PostHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostHistory extends EntityPathBase<PostHistory> {

    private static final long serialVersionUID = 1150544672L;

    public static final QPostHistory postHistory = new QPostHistory("postHistory");

    public final StringPath adminLoginId = createString("adminLoginId");

    public final EnumPath<com.risingcamp.grittest.repository.post.entity.PostStatus> afterStatus = createEnum("afterStatus", com.risingcamp.grittest.repository.post.entity.PostStatus.class);

    public final EnumPath<com.risingcamp.grittest.repository.post.entity.PostStatus> beforeStatus = createEnum("beforeStatus", com.risingcamp.grittest.repository.post.entity.PostStatus.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath reason = createString("reason");

    public QPostHistory(String variable) {
        super(PostHistory.class, forVariable(variable));
    }

    public QPostHistory(Path<? extends PostHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostHistory(PathMetadata metadata) {
        super(PostHistory.class, metadata);
    }

}

