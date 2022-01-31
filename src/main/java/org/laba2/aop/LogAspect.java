package org.laba2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* org.laba2.controllers.*.*(..))")
    private void selectAll() {}

//    @Before("execution(* org.laba2.controllers.TourController.*(..))")
    @Before("selectAll()")
    public void logMethod(JoinPoint joinPoint) {
        System.out.println("logMethod is running");
        System.out.println("Details: " + joinPoint.getSignature().getName());
        System.out.println("************************************");
    }
}
