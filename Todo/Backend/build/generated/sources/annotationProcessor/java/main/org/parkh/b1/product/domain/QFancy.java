package org.parkh.b1.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFancy is a Querydsl query type for Fancy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFancy extends EntityPathBase<Fancy> {

    private static final long serialVersionUID = -483446173L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFancy fancy = new QFancy("fancy");

    public final org.parkh.b1.common.domain.QBaseEntity _super = new org.parkh.b1.common.domain.QBaseEntity(this);

    public final StringPath fancyWriter = createString("fancyWriter");

    public final NumberPath<Long> fno = createNumber("fno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final QProduct product;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QFancy(String variable) {
        this(Fancy.class, forVariable(variable), INITS);
    }

    public QFancy(Path<? extends Fancy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFancy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFancy(PathMetadata metadata, PathInits inits) {
        this(Fancy.class, metadata, inits);
    }

    public QFancy(Class<? extends Fancy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

