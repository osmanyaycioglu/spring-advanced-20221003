package com.training.spring.advanced.jpa;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenderConverter implements AttributeConverter<String,String> {
    private static Map<String,String> converterMap = new HashMap<>();

    static {
        converterMap.put("erkek","MALE");
        converterMap.put("male","MALE");
        converterMap.put("e","MALE");
        converterMap.put("kadın","FEMALE");
        converterMap.put("kadin","FEMALE");
        converterMap.put("female","MALE");
        converterMap.put("f","MALE");
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        String s = converterMap.get(attribute);
        if (s == null){
            s = "UNKNOWN";
        }
        return s;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
