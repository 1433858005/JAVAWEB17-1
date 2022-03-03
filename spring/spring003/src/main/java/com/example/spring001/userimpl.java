package com.example.spring001;

import com.example.spring001.dao.BookDao;
import com.example.spring001.dao.UserDao;

public class userimpl implements user{
    //引应用类型
    private UserDao userDao;
    private BookDao bookDao;
    //1.对需要进行诸如的变量添加set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("执行了");
        userDao.save();
        bookDao.save();
    }

}