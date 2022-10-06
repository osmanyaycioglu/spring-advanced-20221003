package com.training.spring.advanced.customer.data;

import com.training.spring.advanced.customer.services.models.CustomerDetails;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;

public interface ICustomerDetailsDao extends CrudRepository<CustomerDetails, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    CustomerDetails findByCustomerId(Long customerId);

}
