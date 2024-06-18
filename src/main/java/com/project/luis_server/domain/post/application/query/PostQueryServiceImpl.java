package com.project.luis_server.domain.post.application.query;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.PostSearchRequest;
import com.project.luis_server.domain.post.domain.repository.query.PostQueryRepository;
import com.project.luis_server.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {

    private final PostQueryRepository postQueryRepository;

    @Override
    public List<Post> postList(PageRequest request) {
        return postQueryRepository.postList(request);
    }

    @Override
    public List<Post> postSearch(PostSearchRequest request) {
        return postQueryRepository.postSearch(request);
    }

}
