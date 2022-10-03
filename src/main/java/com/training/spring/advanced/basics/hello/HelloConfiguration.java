package com.training.spring.advanced.basics.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    @Bean
    public IHello helloDinamik(){
        return new HelloEng();
    }


}
