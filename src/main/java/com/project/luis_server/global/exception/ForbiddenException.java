package com.project.luis_server.global.exception;

import com.project.luis_server.global.exception.error.ErrorCode;

public class ForbiddenException extends BusinessException {
    
    public static final ForbiddenException EXCEPTION = new ForbiddenException();

    private ForbiddenException(){
        super(ErrorCode.FORBIDDEN);
    }
    
}
