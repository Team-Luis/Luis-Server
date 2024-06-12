package com.project.luis_server.domain.user.exception;

import com.project.luis_server.domain.user.exception.error.UserError;
import com.project.luis_server.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserError.USER_NOT_FOUND);
    }

}
