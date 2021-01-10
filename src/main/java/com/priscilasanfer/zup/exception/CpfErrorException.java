package com.priscilasanfer.zup.exception;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "default.cpf_required")
public class CpfErrorException extends RuntimeException{
    public CpfErrorException(String message) {
        super(message);
    }
}
