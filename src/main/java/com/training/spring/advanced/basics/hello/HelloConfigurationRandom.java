package com.training.spring.advanced.basics.hello;

import a.b.c.HelloEsp;
import com.training.spring.advanced.app.properties.ApplicationProp;
import com.training.spring.advanced.conditional.PropertyCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.security.SecureRandom;
import java.util.Random;

@Configuration
@Profile("random")
public class HelloConfigurationRandom {


    @Bean
    public IHello helloDinamik(ApplicationProp applicationProp) {
        Random random = new SecureRandom();
        int index = random.nextInt(3);
        switch (index) {
            case 0:
                return new HelloTr();
            case 1:
                return new HelloEsp();
            case 2:
            default:
                return new HelloEng();
        }
    }

}
