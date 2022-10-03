package com.training.spring.advanced.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class PropertyCheckImpl implements Condition {

    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(PropertyCheck.class.getName());
        if (attrs != null) {
            for (Object value : attrs.get("propertyName")) {
                String s = (String) value;
                return context.getEnvironment().containsProperty(s);
            }
        }
        return false;
    }
}
