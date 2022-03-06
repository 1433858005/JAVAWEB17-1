package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    public void save(int i){
//        0.将共性功能抽取出来
//        System.out.println("共性功能");
        System.out.println("user service 运行"+i);
    }

    @Override
    public int update() {
        System.out.println("update运行");
        return 100;
    }

    @Override
    public void delete() {
        System.out.println("delete运行");
        int i=1/0;
    }
}
