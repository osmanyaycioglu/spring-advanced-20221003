package com.training.spring.advanced.basics.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloDyn implements IHello{

    @Value("#{customerConfig.dynamicStr()}")
    private String prefix;

    public HelloDyn(@Value("${app.hello.dyn.prefix}") String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String hello(String name) {
        return prefix + " " + name;
    }
}
