package com.training.spring.advanced.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotStartWithImpl implements ConstraintValidator<NotStartWith,String> {

    private NotStartWith anno;

    @Override
    public void initialize(NotStartWith anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        for (String str:anno.value()) {
            if (value.startsWith(str)){
                return false;
            }
        }
        return true;
    }
}
