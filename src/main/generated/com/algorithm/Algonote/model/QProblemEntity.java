package com.algorithm.Algonote.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProblemEntity is a Querydsl query type for ProblemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProblemEntity extends EntityPathBase<ProblemEntity> {

    private static final long serialVersionUID = 386205920L;

    public static final QProblemEntity problemEntity = new QProblemEntity("problemEntity");

    public final StringPath category = createString("category");

    public final StringPath code = createString("code");

    public final StringPath difficulty = createString("difficulty");

    public final StringPath language = createString("language");

    public final NumberPath<Long> problemNum = createNumber("problemNum", Long.class);

    public final StringPath problemSite = createString("problemSite");

    public final StringPath solved = createString("solved");

    public final StringPath text = createString("text");

    public final StringPath title = createString("title");

    public final StringPath userid = createString("userid");

    public QProblemEntity(String variable) {
        super(ProblemEntity.class, forVariable(variable));
    }

    public QProblemEntity(Path<? extends ProblemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProblemEntity(PathMetadata metadata) {
        super(ProblemEntity.class, metadata);
    }

}

