package com.project.luis_server.domain.post.application.service;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;
import com.project.luis_server.domain.post.domain.mapper.PostMapper;
import com.project.luis_server.domain.post.domain.repository.jpa.PostRepository;
import com.project.luis_server.domain.post.exception.PostNotFoundException;
import com.project.luis_server.domain.user.application.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserUtil userUtil;

    @Override
    public void registerPost(PostRegisterRequest request) {
        postRepository.save(postMapper.toCreate(request, userUtil.findUser().getUserId()));
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository
                .findByIdx(postId)
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
        postRepository.deleteByIdx(post.getIdx());
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository
                .findByIdx(postId)
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
    }

}
