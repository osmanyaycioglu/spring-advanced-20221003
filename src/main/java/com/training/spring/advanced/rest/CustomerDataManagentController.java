package com.training.spring.advanced.rest;

import com.training.spring.advanced.rest.models.CustomerRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/data/management")
public class CustomerDataManagentController {

    @PostMapping("/update")
    public String update(CustomerRest customerRest){
       return "OK";
    }


}
