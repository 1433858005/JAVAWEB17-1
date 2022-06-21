package com.example.english4;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class aa {
    @SneakyThrows
    public static void main(String[] args) {
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/e?serverTimezone=UTC&useSSL=true&useUnicode=true&characterEncoding=utf8", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String sql = "INSERT INTO e.ceshi VALUES (5,'123','123','123',now())";
        stat.execute(sql);
        stat.close();
        con.close();
    }
}
