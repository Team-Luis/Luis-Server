package com.project.luis_server.domain.post.application.service;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.PostEditRequest;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;

public interface PostService {
    void registerPost(PostRegisterRequest request);

    void deletePost(Long postId);

    Post getPost(Long postId);

    void editPost(PostEditRequest request);
}
