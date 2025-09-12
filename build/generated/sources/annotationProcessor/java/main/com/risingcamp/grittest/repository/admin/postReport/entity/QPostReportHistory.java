package com.risingcamp.grittest.repository.admin.postReport.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostReportHistory is a Querydsl query type for PostReportHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostReportHistory extends EntityPathBase<PostReportHistory> {

    private static final long serialVersionUID = 725855416L;

    public static final QPostReportHistory postReportHistory = new QPostReportHistory("postReportHistory");

    public final StringPath adminLoginId = createString("adminLoginId");

    public final EnumPath<com.risingcamp.grittest.repository.postReport.entity.PostReportStatus> afterStatus = createEnum("afterStatus", com.risingcamp.grittest.repository.postReport.entity.PostReportStatus.class);

    public final EnumPath<com.risingcamp.grittest.repository.postReport.entity.PostReportStatus> beforeStatus = createEnum("beforeStatus", com.risingcamp.grittest.repository.postReport.entity.PostReportStatus.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath reason = createString("reason");

    public QPostReportHistory(String variable) {
        super(PostReportHistory.class, forVariable(variable));
    }

    public QPostReportHistory(Path<? extends PostReportHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostReportHistory(PathMetadata metadata) {
        super(PostReportHistory.class, metadata);
    }

}

