package com.training.spring.advanced.rest;

import com.training.spring.advanced.basics.models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/data/management")
public class CustomerDataManagentController {

    @PostMapping("/update")
    public String update(Customer customer){
       return "OK";
    }


}
