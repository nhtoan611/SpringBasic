package com.nhtoan611.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoExceptionAspect {
//    @AfterThrowing(pointcut = "execution(* getAccountById())", throwing = "exc")
//    public void getAccount(Throwable exc) {
//        System.out.println("\n=====>>> @AfterThrowing runnnn");
//        System.out.println("\n=====>>> Exception: " + exc);
//
//    }

    @Around("execution(* getAccountById())")
    public void getAccount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // get excute method name
        String method = proceedingJoinPoint.getSignature().toShortString();
        // get start time
        long begin = System.currentTimeMillis();
        // execute method
//        try {
//            proceedingJoinPoint.proceed();
//        } catch (Exception ex) {
//            ex.printStackTrace(); // Catch exception while execute
//        }
//        proceedingJoinPoint.proceed();
        // get end time
        long end = System.currentTimeMillis();
        // get excute time
        long duration = end - begin;

        System.out.println("Excute time: " + duration / 1000.0);
    }
}
