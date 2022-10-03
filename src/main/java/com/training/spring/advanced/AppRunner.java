package com.training.spring.advanced;

import com.training.spring.advanced.app.properties.ApplicationProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private ApplicationProp applicationProp;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(applicationProp);
    }
}
