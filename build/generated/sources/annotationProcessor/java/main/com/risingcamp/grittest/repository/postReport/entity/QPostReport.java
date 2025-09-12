package com.risingcamp.grittest.repository.postReport.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostReport is a Querydsl query type for PostReport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostReport extends EntityPathBase<PostReport> {

    private static final long serialVersionUID = 18361341L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostReport postReport = new QPostReport("postReport");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final com.risingcamp.grittest.repository.user.entity.QUser createdBy;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.risingcamp.grittest.repository.post.entity.QPost post;

    public final EnumPath<PostReportStatus> postReportStatus = createEnum("postReportStatus", PostReportStatus.class);

    public final StringPath title = createString("title");

    public QPostReport(String variable) {
        this(PostReport.class, forVariable(variable), INITS);
    }

    public QPostReport(Path<? extends PostReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostReport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostReport(PathMetadata metadata, PathInits inits) {
        this(PostReport.class, metadata, inits);
    }

    public QPostReport(Class<? extends PostReport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.risingcamp.grittest.repository.user.entity.QUser(forProperty("createdBy")) : null;
        this.post = inits.isInitialized("post") ? new com.risingcamp.grittest.repository.post.entity.QPost(forProperty("post"), inits.get("post")) : null;
    }

}

