package com.nhtoan611.cruddemo2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DemoLoggingAspect.class);
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution (* com.nhtoan611.cruddemo2.controller.*.*(..))")
    private void forControllerPkg() {}

    @Pointcut("execution (* com.nhtoan611.cruddemo2.service.*.*(..))")
    private void forServicePkg() {}

    @Pointcut("execution (* com.nhtoan611.cruddemo2.dao.*.*(..))")
    private void forDAOPkg() {}

    @Pointcut("forControllerPkg() || forServicePkg() || forDAOPkg()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // Display method name
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("====> Before: Calling method: " + methodName);

        // Display arguments list
        Object[] args = joinPoint.getArgs();
        for(Object o: args) {
            logger.info("===> Argument: " + o);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("====> After: Calling method: " + methodName);
        logger.info("===> Result: " + result);
    }
 }
