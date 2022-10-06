package com.training.spring.advanced.customer.services;

import com.training.spring.advanced.customer.data.CustomerData;
import com.training.spring.advanced.customer.data.CustomerDetailsData;
import com.training.spring.advanced.customer.services.models.Customer;
import com.training.spring.advanced.customer.services.models.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

@Service
public class CustomerProvisionService {
    @Autowired
    private CustomerData customerData;
    @Autowired
    private CustomerDetailsData customerDetailsData;

    @Transactional(propagation = Propagation.REQUIRED)
    public Long addCustomer(Customer customer) {
        // Entegrasyon layerından bilgi aldım
        CustomerDetails customerDetails = new CustomerDetails().setGender("MALE")
                                                               .setNote("Department" + new SecureRandom().nextInt());
        Long aLong = customerData.insertCustomer(customer);
        customerDetails.setCustomerId(aLong);
        customerDetailsData.insertCustomerDetails(customerDetails);
        // Another entegrayon layer call
        return aLong;
    }

    public String enable(Long customerId) {
        return "OK";
    }

    public String disable(Long customerId) {
        return "OK";
    }

}
