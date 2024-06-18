package com.project.luis_server.domain.post.client.dto.request;

import com.project.luis_server.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest extends PageRequest {

    private String title;

}
