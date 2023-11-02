package com.healthApi.demo.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Adress {
    private String street;
    private Integer number;
    private String city;
    private String state;
    private String zipCode;

    public Adress(String street, Integer number, String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Adress(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(street, adress.street) && Objects.equals(number, adress.number) && Objects.equals(city, adress.city) && Objects.equals(state, adress.state) && Objects.equals(zipCode, adress.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, city, state, zipCode);
    }
}
