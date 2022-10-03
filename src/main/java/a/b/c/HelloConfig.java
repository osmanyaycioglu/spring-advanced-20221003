package a.b.c;

import com.training.spring.advanced.basics.hello.IHello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloEsp helloEsp(){
        return new HelloEsp();
    }

}
