package com.training.spring.advanced.proxy;

public class MyUsageObj {
    public static void main(String[] args) {
        MyOriginalObj myOriginalObj = new MyOriginalObjProxy();
        System.out.println(myOriginalObj.walk("osman"));
        System.out.println(myOriginalObj.speak("osman"));
    }
}
