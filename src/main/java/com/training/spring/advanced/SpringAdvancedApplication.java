package com.training.spring.advanced;

import a.b.c.HelloConfig;
import a.b.c.HelloEsp;
import com.training.spring.advanced.basics.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@SpringBootApplication(scanBasePackages = {"com.training.spring.advanced","a.b.c"})
@SpringBootApplication
@Import(HelloConfig.class)
@EnableAspectJAutoProxy
@EnableScheduling
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringAdvancedApplication {

    @Autowired
    private HelloEsp helloEsp;

    private int counter = 0;

    @Scheduled(fixedDelayString = "${osman.schedule.timeout}", initialDelayString = "${osman.schedule.timeout}")
    public void showCounter() {
        System.out.println("Counter : " + counter++);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class,
                              args);
    }

}
