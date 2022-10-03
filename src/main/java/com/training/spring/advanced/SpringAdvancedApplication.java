package com.training.spring.advanced;

import a.b.c.HelloConfig;
import a.b.c.HelloEsp;
import com.training.spring.advanced.basics.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@SpringBootApplication(scanBasePackages = {"com.training.spring.advanced","a.b.c"})
@SpringBootApplication
@Import(HelloConfig.class)
public class SpringAdvancedApplication {

    @Autowired
    private HelloEsp helloEsp;

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class,
                              args);
    }

}
