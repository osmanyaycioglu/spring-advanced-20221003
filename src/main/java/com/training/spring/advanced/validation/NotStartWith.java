package com.training.spring.advanced.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Constraint(validatedBy = {NotStartWithImpl.class,NotStartWithCustomerImpl.class })
public @interface NotStartWith {

    String[] value();

    String message() default "{javax.validation.constraints.NotStartWith.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
