package com.risingcamp.grittest.repository.admin.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserHistory is a Querydsl query type for UserHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserHistory extends EntityPathBase<UserHistory> {

    private static final long serialVersionUID = 538873994L;

    public static final QUserHistory userHistory = new QUserHistory("userHistory");

    public final StringPath adminLoginId = createString("adminLoginId");

    public final EnumPath<com.risingcamp.grittest.repository.user.entity.UserStatus> afterStatus = createEnum("afterStatus", com.risingcamp.grittest.repository.user.entity.UserStatus.class);

    public final EnumPath<com.risingcamp.grittest.repository.user.entity.UserStatus> beforeStatus = createEnum("beforeStatus", com.risingcamp.grittest.repository.user.entity.UserStatus.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath reason = createString("reason");

    public QUserHistory(String variable) {
        super(UserHistory.class, forVariable(variable));
    }

    public QUserHistory(Path<? extends UserHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserHistory(PathMetadata metadata) {
        super(UserHistory.class, metadata);
    }

}

