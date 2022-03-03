package com.example.spring001.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.spring001.config.SpringConfig;
import com.example.spring001.dao.BookDao;
import com.example.spring001.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class userapp {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext选org
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);

        //user接口名
//  <bean id="user"  class="userimpl"/>因为这里的id是user
//如果bean里有name属性，则这里可以用name值代替id的值
        user user=(user) ctx.getBean("user");
        user.save();
//        UserDao userDao= (UserDao) ctx.getBean("userDao");
//        userDao.save();
        BookDao bookDao=(BookDao) ctx.getBean("bookDao");
        bookDao.save();
//        DruidDataSource dataSource= (DruidDataSource) ctx.getBean("dataSource");
//        System.out.println(dataSource);
    }
}