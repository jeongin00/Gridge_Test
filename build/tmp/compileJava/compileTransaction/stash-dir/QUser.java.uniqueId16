package com.risingcamp.grittest.repository.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -791483925L;

    public static final QUser user = new QUser("user");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath loginId = createString("loginId");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath providerId = createString("providerId");

    public final EnumPath<com.risingcamp.grittest.repository.user.entity.vo.Source> source = createEnum("source", com.risingcamp.grittest.repository.user.entity.vo.Source.class);

    public final BooleanPath termsAgreed = createBoolean("termsAgreed");

    public final DateTimePath<java.time.LocalDateTime> termsAgreedAt = createDateTime("termsAgreedAt", java.time.LocalDateTime.class);

    public final EnumPath<UserStatus> userStatus = createEnum("userStatus", UserStatus.class);

    public final EnumPath<UserType> userType = createEnum("userType", UserType.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

