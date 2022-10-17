package com.example.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class MonitorAspect {

    @Pointcut("execution(* com.example.service..*.*(..))")
    private void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("ready to enter function" + " " + new Date());
        System.out.println(joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after" + new Date());
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("after returning" + new Date());
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("after throwing" + new Date());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String functionName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object returnVal = null;
        try {
            returnVal = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("function:" + functionName + " is done");
        }
        return returnVal;
    }

}
