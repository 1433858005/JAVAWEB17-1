package com.example.spring001.service.Impl;

import com.example.spring001.service.user;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//定义bean后面添加bean的id
@Component("user")
//设定bean的作用域
@Scope("singleton")
public class userimpl implements user {
    public void save() {
        System.out.println("执行了");
    }
    //设定bean的生命周期
    @PreDestroy
    public void init() {
        System.out.println("inot执行了");
    }
    //设定bean的生命周期
    @PostConstruct
    public void destroy() {
        System.out.println("destroy执行了");
    }
}