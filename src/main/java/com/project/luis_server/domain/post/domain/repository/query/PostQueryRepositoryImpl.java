package com.project.luis_server.domain.post.domain.repository.query;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.luis_server.domain.post.domain.QPostEntity.postEntity;

@Repository
@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> postList(PageRequest request) {
        return jpaQueryFactory
                .select(postListConstructorExpression())
                .from(postEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(postEntity.idx.asc())
                .fetch();
    }

    private ConstructorExpression<Post> postListConstructorExpression(){
        return Projections.constructor(Post.class,
                postEntity.idx,
                postEntity.title,
                postEntity.content,
                postEntity.author
        );
    }

}
