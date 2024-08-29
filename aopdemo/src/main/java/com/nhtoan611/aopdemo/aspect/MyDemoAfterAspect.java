package com.nhtoan611.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Aspect
@Component
public class MyDemoAfterAspect {
    @AfterReturning(pointcut = "execution(* getAccountId())", returning = "accountIds")
    public void beforeAddAccount(List<Integer> accountIds) {
        System.out.println("\n=====>>> @AfterRutrning runnnn");
        accountIds.forEach(data -> {
            System.out.println(data);
        });
    }
}
