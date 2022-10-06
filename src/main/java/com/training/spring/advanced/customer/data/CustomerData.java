package com.training.spring.advanced.customer.data;

import com.training.spring.advanced.customer.services.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerData {

    @Autowired
    private ICustomerDao customerDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertCustomer(Customer customer) {
        Customer savedCustomer = customerDao.save(customer);
        return savedCustomer.getCustomerId();
    }

    public Customer getCustomer(Long customerId) {
        return customerDao.findById(customerId)
                          .orElse(null);
    }

    public List<Customer> getAll() {
        Iterable<Customer> all = customerDao.findAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : all) {
            customerList.add(customer);
        }
        return customerList;
    }

    public List<Customer> getBySurname(String surname) {
        return customerDao.findBySurname(surname);
    }
}
