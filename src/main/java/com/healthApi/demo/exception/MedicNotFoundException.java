package com.healthApi.demo.exception;

public class MedicNotFoundException extends RuntimeException{
    public MedicNotFoundException(String msg){
        super(msg);
    }
}
