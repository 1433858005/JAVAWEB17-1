package com.example.spring001.dao.Impl;

import com.example.spring001.dao.UserDao;

public class UserDaoImpl implements UserDao {
    private String username;
    private String passward;
    //生成构造方法
    public UserDaoImpl(String username, String passward) {
        this.username = username;
        this.passward = passward;
    }

    @Override
    public void save() {
        System.out.println("user service running..."+username+passward);
    }
}
