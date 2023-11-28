package com.healthApi.demo.exception;

public class PatientNotCreatedException extends RuntimeException {
    public PatientNotCreatedException(String s) {
        super(s);
    }
}
