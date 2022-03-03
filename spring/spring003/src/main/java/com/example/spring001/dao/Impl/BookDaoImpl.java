package com.example.spring001.dao.Impl;

import com.example.spring001.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("user service running...");
    }

}
