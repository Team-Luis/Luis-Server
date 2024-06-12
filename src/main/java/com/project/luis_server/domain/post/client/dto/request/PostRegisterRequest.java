package com.project.luis_server.domain.post.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRegisterRequest {

    private String title;
    private String content;

}
