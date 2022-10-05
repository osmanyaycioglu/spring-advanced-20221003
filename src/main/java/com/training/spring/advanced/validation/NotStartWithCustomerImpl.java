package com.training.spring.advanced.validation;

import com.training.spring.advanced.rest.models.CustomerRest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class NotStartWithCustomerImpl implements ConstraintValidator<NotStartWith, CustomerRest> {

    private NotStartWith anno;

    @Override
    public void initialize(NotStartWith anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(CustomerRest value,
                           ConstraintValidatorContext context) {
        Class<? extends CustomerRest> aClass = value.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        boolean retVat = true;
        for (Field field : declaredFields) {
            if (field.getType() == String.class) {
                field.setAccessible(true);
                try {
                    String fieldValue = (String) field.get(value);
                    for (String str : anno.value()) {
                        if (fieldValue.startsWith(str)) {
                            context.disableDefaultConstraintViolation();
                            ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = context.buildConstraintViolationWithTemplate(field.getName() + " must not start with {value} ");
                            constraintViolationBuilder.addConstraintViolation();
                            retVat = false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return retVat;
    }
}
