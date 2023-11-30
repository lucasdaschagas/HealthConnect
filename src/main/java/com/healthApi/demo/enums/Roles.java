package com.healthApi.demo.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Roles {
    CARDIOLOGY(1),
    PHYSIOLOGIST(2),
    OPHTHALMOLOGY(3),
    ORTHOPEDICS(4),
    CLINICAL(5);


    private final int code;

    Roles(int code){
        this.code=code;
    }


    public int getCode() {
        return code;
    }


    public static Roles valueOf(int code){
        for(Roles value : Roles.values()){
            if(value.getCode() == code){
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid role code, this professional does not exist");
    }


    public static Roles fromString(String value) {
        for (Roles role : Roles.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + value);
    }
}

