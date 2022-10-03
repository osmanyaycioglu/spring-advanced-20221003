package com.training.spring.advanced.basics.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloTr implements IHello {

    @Override
    public String hello(String name) {
        return "merhaba " + name;
    }
}
