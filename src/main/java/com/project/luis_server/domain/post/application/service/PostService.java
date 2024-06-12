package com.project.luis_server.domain.post.application.service;

import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;

public interface PostService {
    void registerPost(PostRegisterRequest request);
}
