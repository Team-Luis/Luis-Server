package com.project.luis_server.global.exception;


import com.project.luis_server.global.exception.error.ErrorCode;

public class BadRequestException extends BusinessException {
    
    public static final BadRequestException EXCEPTION = new BadRequestException();
    
    private BadRequestException(){
        super(ErrorCode.BAD_REQUEST);
    }

}
