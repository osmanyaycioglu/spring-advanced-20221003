package a.b.c;

import com.training.spring.advanced.basics.hello.IHello;
import org.springframework.stereotype.Component;

//@Component
public class HelloEsp implements IHello {
    @Override
    public String hello(String name) {
        return "Ola " + name;
    }
}
