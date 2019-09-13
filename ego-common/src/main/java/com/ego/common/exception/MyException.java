package com.ego.common.exception;

public class MyException extends RuntimeException {

    public MyException(EgoException exception) {
        super(exception.toString());
    }
}
