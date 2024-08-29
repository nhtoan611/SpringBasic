package com.nhtoan611.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(void addAccount())")
    public void beforeAddAccount(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before");
        theJoinPoint.getArgs();
    }
}
