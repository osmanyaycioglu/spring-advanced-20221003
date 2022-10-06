package com.training.spring.advanced.customer.services;

import com.training.spring.advanced.customer.data.CustomerData;
import com.training.spring.advanced.customer.services.models.Customer;
import com.training.spring.advanced.rest.models.CustomerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerDataService {

    @Autowired
    private CustomerData customerData;

    public Customer getOneCustomer(Long customerId) {
        return customerData.getCustomer(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerData.getAll();
    }

    public List<Customer> getCustomersBySurname(String surname) {
        return customerData.getBySurname(surname);
    }

}
