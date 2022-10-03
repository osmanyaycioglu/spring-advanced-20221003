package com.training.spring.advanced.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Conditional(PropertyCheckImpl.class)
public @interface PropertyCheck {
    String propertyName();
    int propIndex() default 10;
}
