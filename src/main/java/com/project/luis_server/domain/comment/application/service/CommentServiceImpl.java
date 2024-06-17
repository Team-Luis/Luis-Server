package com.project.luis_server.domain.comment.application.service;

import com.project.luis_server.domain.comment.client.dto.request.CommentRegisterRequest;
import com.project.luis_server.domain.comment.domain.mapper.CommentMapper;
import com.project.luis_server.domain.comment.domain.repository.jpa.CommentRepository;
import com.project.luis_server.domain.comment.exception.CommentNotFoundException;
import com.project.luis_server.domain.post.domain.repository.jpa.PostRepository;
import com.project.luis_server.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;
    private final UserSecurity userSecurity;

    @Override
    public void registerComment(CommentRegisterRequest request) {
        if(postRepository.findByIdx(request.getPostId()).isEmpty()) {
            throw CommentNotFoundException.EXCEPTION;
        }
        commentRepository.save(commentMapper.toEntity(
                request,
                userSecurity.getUser().getUserId()));
    }

}
