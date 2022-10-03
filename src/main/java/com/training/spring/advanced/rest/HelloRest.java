package com.training.spring.advanced.rest;

import com.training.spring.advanced.basics.hello.IHello;
import com.training.spring.advanced.basics.models.Customer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/greetings")
@Valid
public class HelloRest {

    @Autowired
    @Qualifier("helloDinamik")
    private IHello hello;

    @GetMapping("/hello")
    @Operation(summary = "greet to new customer",description = "herkese selam gönderen yapı")
    public String hello(@NotEmpty @RequestParam("isim") String name,
                        @NotEmpty @RequestParam("soy") String surname) {
        return hello.hello(name + " " + surname);
    }

    @GetMapping("/hello2/{abc}")
    public String hello2(@PathVariable("abc") String name,
                         @RequestParam("soy") String surname) {
        return hello.hello(name + " " + surname);
    }

    @PostMapping("/hello3")
    public String hello3(@Valid @RequestBody Customer customer) {
        return hello.hello(customer.getName() + " " + customer.getSurname());
    }

}
