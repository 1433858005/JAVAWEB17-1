package com.example.spring001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class userapp {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext选org
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //user接口名
//  <bean id="user"  class="userimpl"/>因为这里的id是user
//如果bean里有name属性，则这里可以用name值代替id的值
        user user=(user) ctx.getBean("user");
        user.save();
    }
}