package com.project.luis_server.domain.comment.application.service;

import com.project.luis_server.domain.comment.client.dto.request.CommentRegisterRequest;

public interface CommentService {

    void registerComment(CommentRegisterRequest request);

}
