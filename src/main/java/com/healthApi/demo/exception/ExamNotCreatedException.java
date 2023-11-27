package com.healthApi.demo.exception;

public class ExamNotCreatedException extends RuntimeException{
    public ExamNotCreatedException(String msg){
        super(msg);
    }
}
