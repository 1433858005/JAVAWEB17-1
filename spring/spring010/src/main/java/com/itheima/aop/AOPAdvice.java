package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//制作通知类，在类中定义一个方法用于完成共性功能
@Aspect
public class AOPAdvice {
    @Pointcut("execution(* *..*(..))")
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        System.out.println("共性功能" + "before");
    }

    @After("pt()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pt()")
    public void afterReturing() {
        System.out.println("afterReturing");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around brfore");
        //对原始方法的调用
      Object ret=  pjp.proceed();
        System.out.println("around after");
        return ret;
    }

}
