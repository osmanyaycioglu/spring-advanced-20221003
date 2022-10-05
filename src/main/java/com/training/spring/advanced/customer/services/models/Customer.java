package com.training.spring.advanced.customer.services.models;

import com.training.spring.advanced.validation.NotStartWith;

import javax.validation.constraints.*;
import java.util.List;

public class Customer {
    private String name;
    private String  surname;
    private Integer weight;
    private Integer height;
    private String password;
    private EStatus customerState;
    private Address address;
    private List<Phone> phoneList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EStatus getCustomerState() {
        return customerState;
    }

    public void setCustomerState(EStatus customerState) {
        this.customerState = customerState;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
