package com.project.luis_server.domain.post.application.service;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.AddLikesRequest;
import com.project.luis_server.domain.post.client.dto.request.PostEditRequest;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;
import com.project.luis_server.domain.post.domain.mapper.PostMapper;
import com.project.luis_server.domain.post.domain.repository.jpa.PostRepository;
import com.project.luis_server.domain.post.exception.PostNotFoundException;
import com.project.luis_server.domain.user.application.util.UserUtil;
import com.project.luis_server.domain.user.client.dto.User;
import com.project.luis_server.global.exception.ForbiddenException;
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

    @Override
    public void editPost(PostEditRequest request){
        Post post = postRepository
                .findByIdx(request.getPostId())
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
        User user = userUtil.findUser();
        if(!post.getAuthor().equals(user.getUserId()))
            throw ForbiddenException.EXCEPTION;
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(postMapper.toEdit(post));
    }

    @Override
    public void addLikes(AddLikesRequest request){
        Post post = postRepository
                .findByIdx(request.getPostId())
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
        post.setLikes(post.getLikes() + 1);
        postRepository.save(postMapper.toEdit(post));
    }

}
