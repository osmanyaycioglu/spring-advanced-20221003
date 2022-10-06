package com.training.spring.advanced.aop;

import org.springframework.stereotype.Component;

@Component
public class MyGreetBean {

    public String callMe(String name) {
        return "Greetings " + name;
    }

}
