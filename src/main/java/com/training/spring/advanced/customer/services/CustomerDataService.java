package com.training.spring.advanced.customer.services;

import com.training.spring.advanced.customer.services.models.Customer;
import com.training.spring.advanced.rest.models.CustomerRest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerDataService {

    public Customer getOneCustomer(Long customerId) {
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public List<Customer> getCustomersBySurname(String surname) {
        return null;
    }

}
