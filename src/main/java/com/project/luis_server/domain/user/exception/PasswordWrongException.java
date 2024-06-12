package com.project.luis_server.domain.user.exception;

import com.project.luis_server.domain.user.exception.error.UserError;
import com.project.luis_server.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserError.PASSWORD_WRONG);
    }

}
