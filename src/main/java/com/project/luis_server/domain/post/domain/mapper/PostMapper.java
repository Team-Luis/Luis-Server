package com.project.luis_server.domain.post.domain.mapper;

import com.project.luis_server.domain.post.client.dto.Post;
import com.project.luis_server.domain.post.client.dto.request.PostRegisterRequest;
import com.project.luis_server.domain.post.domain.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostEntity toCreate(PostRegisterRequest request, String userId) {
        return PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(userId)
                .build();
    }

    public Post toPost(PostEntity postEntity) {
        return Post.builder()
                .idx(postEntity.getIdx())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .build();
    }

    public PostEntity toEdit(Post post) {
        return PostEntity.builder()
                .idx(post.getIdx()) // ensure idx is set
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .createdDateTime(post.getCreatedDateTime())
                .build();
    }

}