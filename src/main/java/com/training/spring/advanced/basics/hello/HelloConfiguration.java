package com.training.spring.advanced.basics.hello;

import a.b.c.HelloEsp;
import com.training.spring.advanced.app.properties.ApplicationProp;
import com.training.spring.advanced.conditional.PropertyCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dinamik")
public class HelloConfiguration {


    @Bean
    public IHello helloDinamik(ApplicationProp applicationProp) {
        switch (applicationProp.getHelloLanguage()) {
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new HelloEng();
        }
    }

    @Bean
    @PropertyCheck(propertyName = "hello.dyn.create")
    public IHello helloDinamik2(@Value("${app.hello.language}") String language) {
        switch (language) {
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new HelloEng();
        }
    }


}
