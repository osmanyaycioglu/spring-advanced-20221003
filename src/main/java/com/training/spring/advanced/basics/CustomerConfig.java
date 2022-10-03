package com.training.spring.advanced.basics;

import com.training.spring.advanced.basics.hello.HelloDyn;
import com.training.spring.advanced.basics.hello.HelloEng;
import com.training.spring.advanced.basics.hello.HelloTr;
import com.training.spring.advanced.basics.hello.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    @Qualifier("config-other")
    public CustomerManager otherCM(@Qualifier("helloTr") IHello hello){
        return new CustomerManager(hello);
    }

    @Bean("myCustomerManager")
    public CustomerManager otherCM2(){
        return new CustomerManager(new HelloTr());
    }

    @Bean
    public String dynamicStr(){
        return "Test";
    }

    @Bean
    public HelloDyn helloDynConfig(){
        return new HelloDyn("merhaba");
    }

}
