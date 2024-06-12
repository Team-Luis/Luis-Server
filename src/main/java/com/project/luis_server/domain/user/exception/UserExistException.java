package com.project.luis_server.domain.user.exception;

import com.project.luis_server.domain.user.exception.error.UserError;
import com.project.luis_server.global.exception.BusinessException;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(UserError.USER_EXIST);
    }

}
