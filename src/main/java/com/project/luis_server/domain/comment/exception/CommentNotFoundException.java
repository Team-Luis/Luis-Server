package com.project.luis_server.domain.comment.exception;

import com.project.luis_server.domain.user.exception.error.UserError;
import com.project.luis_server.global.exception.BusinessException;

public class CommentNotFoundException extends BusinessException {

    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();

    private CommentNotFoundException(){
        super(UserError.USER_EXIST);
    }

}
