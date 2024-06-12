package com.project.luis_server.domain.post.exception;

import com.project.luis_server.domain.post.exception.error.PostError;
import com.project.luis_server.global.exception.BusinessException;

public class PostNotFoundException extends BusinessException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostError.POST_NOT_FOUND);
    }

}
