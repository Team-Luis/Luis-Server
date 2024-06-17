package com.project.luis_server.domain.comment.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRegisterRequest {

    private Long postId;
    private String content;

}
