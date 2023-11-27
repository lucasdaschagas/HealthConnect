package com.healthApi.demo.exception;

public class ExamNotFoundException extends RuntimeException{
    public ExamNotFoundException(String msg){
        super(msg);
    }
}
