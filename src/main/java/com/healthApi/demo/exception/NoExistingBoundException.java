package com.healthApi.demo.exception;

public class NoExistingBoundException extends RuntimeException{
    public NoExistingBoundException(String msg){
        super(msg);
    }
}
