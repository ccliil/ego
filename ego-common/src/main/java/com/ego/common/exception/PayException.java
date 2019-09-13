package com.ego.common.exception;


import com.ego.common.enums.ExceptionEnum;

public class PayException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

    public PayException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }


    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
