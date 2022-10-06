package com.training.spring.advanced.customer.data;

import com.training.spring.advanced.customer.services.models.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerDetailsData {
    @Autowired
    private ICustomerDetailsDao customerDetailsDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCustomerDetails(CustomerDetails customerDetails){
        customerDetailsDao.save(customerDetails);
    }
}
