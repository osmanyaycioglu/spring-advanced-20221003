package com.training.spring.advanced.rest;

import com.training.spring.advanced.aop.MyGreetBean;
import com.training.spring.advanced.basics.hello.IHello;
import com.training.spring.advanced.rest.models.CustomerRest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
    @RequestMapping("/greetings")
@Valid
public class HelloRest {

    @Autowired
    @Qualifier("helloDinamik")
    private IHello hello;

    @Autowired
    private MyGreetBean myGreetBean;

    @GetMapping("/greet")
   public String greet(@NotEmpty @RequestParam("isim") String name) {
        return myGreetBean.callMe(name);
    }

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
    public String hello3(@Valid @RequestBody CustomerRest customerRest) {
        if (customerRest.getName().startsWith("123")){
            throw new IllegalArgumentException("password 123 ile başlayamaz");
        }
        return hello.hello(customerRest.getName() + " " + customerRest.getSurname());
    }

}
