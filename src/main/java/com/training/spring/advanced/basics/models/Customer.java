package com.training.spring.advanced.basics.models;

import com.training.spring.advanced.validation.NotStartWith;

import javax.validation.constraints.*;

@NotStartWith({"test","dev"})
public class Customer {
    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2,max = 15,message = "name {min} ile {max} arasında olmalı")
    private String name;
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3,max = 20,message = "surname {min} ile {max} arasında olmalı")
    private String  surname;
    @Positive
    @Min(20)
    @Max(300)
    private Integer weight;
    @Min(50)
    @Max(250)
    private Integer height;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    @NotStartWith({"12345","fb","gs","xyz"})
    private String password;

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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
