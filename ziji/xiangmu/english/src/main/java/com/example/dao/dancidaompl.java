package com.example.dao;
import com.example.http.servicehttp;

import java.sql.*;

import static com.example.dao.dao01.allid;

public class dancidaompl {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
           int aa=  allid("english.english0001");

//        System.out.println(getname("english.english0002",1));
    }

    private static void tianjia2(String a,int b,String c,String d) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english?useSSL=true&useUnicode=true&characterEncoding=utf8", "root", "15149622693");
        Statement stat = con.createStatement();
        String sql = "INSERT INTO "+a+" VALUES ('"+b+"','"+c+"','"+d+"')";
        stat.execute(sql);
        stat.close();
        con.close();
    }
}
