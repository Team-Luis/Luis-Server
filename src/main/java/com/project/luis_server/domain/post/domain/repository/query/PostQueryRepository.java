package com.project.luis_server.domain.post.domain.repository.query;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.PostSearchRequest;
import com.project.luis_server.global.common.dto.request.PageRequest;

import java.util.List;

public interface PostQueryRepository {
    List<Post> postList(PageRequest request);

    List<Post> postSearch(PostSearchRequest request);
}
