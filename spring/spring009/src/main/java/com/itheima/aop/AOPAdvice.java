package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//制作通知类，在类中定义一个方法用于完成共性功能
public class AOPAdvice {
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("共性功能" + "before"+args[0]);
    }

    public void after() {
        System.out.println("after");
    }

    public void afterReturing(Object ret) {
        System.out.println("afterReturing"+ret);
    }

    public void afterThrowing(Throwable t) {
        System.out.println("afterThrowing"+t.getMessage());
    }

//    public void around(ProceedingJoinPoint pjp) throws Throwable {
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around brfore");
        //对原始方法的调用
//        pjp.proceed();
        Object ret = pjp.proceed();
        System.out.println("around after"+ret);
        return ret;
    }

}
