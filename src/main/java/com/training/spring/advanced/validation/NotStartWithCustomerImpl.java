package com.training.spring.advanced.validation;

import com.training.spring.advanced.basics.models.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class NotStartWithCustomerImpl implements ConstraintValidator<NotStartWith, Customer> {

    private NotStartWith anno;

    @Override
    public void initialize(NotStartWith anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(Customer value,
                           ConstraintValidatorContext context) {
        Class<? extends Customer> aClass = value.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType() == String.class) {
                field.setAccessible(true);
                try {
                    String fieldValue = (String) field.get(value);
                    for (String str : anno.value()) {
                        if (fieldValue.startsWith(str)) {
                            ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = context.buildConstraintViolationWithTemplate(field.getName() + " must not start with {value} ");
                            return false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
