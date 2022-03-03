package com.example.spring001.dao.Impl;

import com.example.spring001.dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
// private String username;
// private String password;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Override
    public void save() {
        System.out.println("user Userdao running...");
    }
}
