package com.training.spring.advanced.basics.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("english-hello")
@Lazy
//@Primary
public class HelloEng implements IHello {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
