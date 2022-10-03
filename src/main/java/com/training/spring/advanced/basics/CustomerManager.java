package com.training.spring.advanced.basics;

import com.training.spring.advanced.basics.hello.HelloEng;
import com.training.spring.advanced.basics.hello.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomerManager {

    // @Autowired

    private IHello hello;

    @Autowired
    public CustomerManager(@Qualifier("helloEng") IHello hello) {
        this.hello = hello;
    }

    @PostConstruct
    public void init(){

    }

    public String greetCustomer(String name){
        return hello.hello(name);
    }

}
