package com.training.spring.advanced.customer.services.models;

import com.training.spring.advanced.jpa.GenderConverter;

import javax.persistence.*;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue
    private Long cdid;
    private String note;
    @Convert(converter = GenderConverter.class)
    private String gender;
    private Long customerId;
    private Long counter; // 5  6 6 7
    @Version
    private Long version; // 1  2 2 3

    public Long getCdid() {
        return cdid;
    }

    public void setCdid(Long cdid) {
        this.cdid = cdid;
    }

    public String getNote() {
        return note;
    }

    public CustomerDetails setNote(String note) {
        this.note = note;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public CustomerDetails setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public CustomerDetails setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}
