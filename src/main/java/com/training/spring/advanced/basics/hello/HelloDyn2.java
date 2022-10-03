package com.training.spring.advanced.basics.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloDyn2 implements IHello{

    private String prefix;

    public HelloDyn2(@Qualifier("dynamicStr") String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String hello(String name) {
        return prefix + " " + name;
    }
}
