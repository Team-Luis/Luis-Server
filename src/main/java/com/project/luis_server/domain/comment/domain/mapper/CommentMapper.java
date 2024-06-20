package com.project.luis_server.domain.comment.domain.mapper;

import com.project.luis_server.domain.comment.client.dto.request.CommentRegisterRequest;
import com.project.luis_server.domain.comment.domain.CommentEntity;
import com.project.luis_server.global.annotation.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public class CommentMapper {

    public CommentEntity toEntity(CommentRegisterRequest request, String userId) {
        return CommentEntity.builder()
                .postId(request.getPostId())
                .content(request.getContent())
                .author(userId)
                .build();
    }

}
