package com.example.spring001.dao.Impl;

import com.example.spring001.dao.BookDao;
import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("user bookdao running...");
    }

}
