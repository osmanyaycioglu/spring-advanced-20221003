package com.training.spring.advanced.rest;

import com.training.spring.advanced.basics.models.Customer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody Customer customer){
       return "OK";
    }

    @GetMapping("/disable")
    public String disable(@RequestParam("cid") Long customerId){
        return "OK";
    }

    @GetMapping("/enable")
    public String enable(@RequestParam("cid") Long customerId){
        return "OK";
    }

}
