package com.training.spring.advanced.proxy;

public class MyOriginalObjProxy extends MyOriginalObj {

    @Override
    public String walk(String name) {
        System.out.println("trans start");
        String walk = null;
        try {
            // Given code part call
            walk = super.walk(name);
            System.out.println("trans commit");

        } catch (Exception exp){
            System.out.println("trans rollback");
            throw  exp;
        }
        return walk;

    }

    @Override
    public String speak(String name) {
        return super.speak(name);

    }

}
