package com.training.spring.advanced.rest;

import com.training.spring.advanced.basics.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/data/query")
public class CustomerDataQueryController {

    @GetMapping("/get/one")
    public Customer getOneCustomer(@RequestParam("cid") Long customerId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Customer> getAllCustomers() {
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<Customer> getCustomersBySurname(@RequestParam("surnamae") String surname) {
        return null;
    }

}
