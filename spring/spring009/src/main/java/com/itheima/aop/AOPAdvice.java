package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//制作通知类，在类中定义一个方法用于完成共性功能
public class AOPAdvice {
    public void before() {
        System.out.println("共性功能" + "before");
    }

    public void after() {
        System.out.println("after");
    }

    public void afterReturing() {
        System.out.println("afterReturing");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around brfore");
        //对原始方法的调用
        pjp.proceed();
        System.out.println("around after");
    }

}
