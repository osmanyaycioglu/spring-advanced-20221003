package com.training.spring.advanced.customer.services.models;

import com.training.spring.advanced.validation.NotStartWith;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
//@Table(name = "musteri")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long        customerId;
    @Size(max = 20)
    @Column(length = 20)
    private String      name;
    //@Column(name = "soy")
    private String      surname;
    @Max(300)
    private Integer     weight;
    private Integer     height;
    private String      password;
    private EStatus     customerState;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address     address;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;

    @PrePersist
    @PreUpdate
    @PreRemove
    public void before() {
        System.out.println("Before DB op");
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    @PostLoad
    public void after() {
        System.out.println("After DB op");
    }

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
