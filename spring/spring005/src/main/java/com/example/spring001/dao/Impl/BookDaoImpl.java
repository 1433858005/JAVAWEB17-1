package com.example.spring001.dao.Impl;

import com.example.spring001.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("bookDao")
@PropertySource("classpath:data.properties")
public class BookDaoImpl implements BookDao {
    @Value("${username2}")
    private String username;
    @Value("${password}")
    private String passward;
    @Override
    public void save() {
        System.out.println("user bookdao running...");
        System.out.println(username+passward);
    }
}
