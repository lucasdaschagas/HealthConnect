package com.healthApi.demo.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
