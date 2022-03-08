package com.example.dao;
import com.example.http.servicehttp;

import java.sql.*;

import static com.example.dao.dao01.allid;

public class dancidaompl {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
           int aa=  allid("english.english0003");
           System.out.println(aa);
    }
    public static int allid(String a) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english?useSSL=true&useUnicode=true&characterEncoding=utf8", "root", "15149622693");
        Statement stat = con.createStatement();
        int allid=0;
        String sql ="SELECT*FROM "+a+" ORDER  BY id DESC LIMIT 1";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
//         System.out.println(rs.getInt("id"));
            allid=rs.getInt("id");
        }
        rs.close();
        stat.close();
        con.close();
        return allid;
    }

}
