package com.healthApi.demo.exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String msg){
        super(msg);
    }
}
