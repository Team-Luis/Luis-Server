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
                .likes(0)
                .category(request.getCategory())
                .build();
    }

    public Post toPost(PostEntity postEntity) {
        return Post.builder()
                .idx(postEntity.getIdx())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .likes(postEntity.getLikes())
                .category(postEntity.getCategory())
                .createdDateTime(postEntity.getCreatedDateTime())
                .modifiedDateTime(postEntity.getModifiedDateTime())
                .build();
    }

    public PostEntity toEdit(Post post) {
        return PostEntity.builder()
                .idx(post.getIdx()) // ensure idx is set
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .likes(post.getLikes())
                .category(post.getCategory())
                .createdDateTime(post.getCreatedDateTime())
                .build();
    }

}