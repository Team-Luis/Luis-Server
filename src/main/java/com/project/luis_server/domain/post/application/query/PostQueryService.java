package com.project.luis_server.domain.post.application.query;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.global.common.dto.request.PageRequest;

import java.util.List;

public interface PostQueryService {
    List<Post> postList(PageRequest request);
}
