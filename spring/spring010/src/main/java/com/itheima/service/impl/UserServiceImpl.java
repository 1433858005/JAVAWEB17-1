package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public int save(int i,int m) {
        System.out.println("service 运行 "+i+m);
        return 100;
    }
}
