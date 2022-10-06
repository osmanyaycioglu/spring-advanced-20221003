package com.training.spring.advanced.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectEnforcer {

    @Before("execution(* com.training.spring.advanced.aop.MyGreetBean.*(..)) && args(val)")
    public void beforeMethod(JoinPoint joinPoint,
                             String val) {
        System.out.println("before MyGreetBean " + joinPoint + " input param : " + val);

    }

    @After("execution(* com.training.spring.advanced.aop.MyGreetBean.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("after MyGreetBean " + joinPoint);
    }

    @AfterReturning(value = "execution(* com.training.spring.advanced.aop.MyGreetBean.*(..))", returning = "retVal")
    public void afterReturnMethod(JoinPoint joinPoint,
                                  String retVal) {
        System.out.println("after returning MyGreetBean " + joinPoint + " retVal : " + retVal);
    }

    @AfterThrowing(value = "execution(* com.training.spring.advanced.aop.MyGreetBean.*(..))", throwing = "exp")
    public void afterReturnMethod(JoinPoint joinPoint,
                                  Exception exp) {
        System.out.println("after returning MyGreetBean " + joinPoint + " exp : " + exp);
    }

    @Around("execution(* com.training.spring.advanced.aop.MyGreetBean.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            String inputParam = (String) args[0];
            if ("osman".equals(inputParam)) {
                return "Osman bundan sonrası sana yok!";
            }
            if ("ali".equals(inputParam)) {
                Object[] newArgs = new Object[1];
                newArgs[0] = "ayşe";
                return proceedingJoinPoint.proceed(newArgs);
            }
            Long delta = System.nanoTime();
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("Method " + proceedingJoinPoint.toShortString() + " delta : " + (System.nanoTime() - delta));
            if (proceed instanceof String) {
                String s = (String) proceed;
                return s + " intercepted";
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
