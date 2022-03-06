package com.example.jdbcceshi001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class a {
    public static void main(String[] args) throws Exception {
//        3.获取连接
    Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english", "root", "15149622693");
//       4.获取执行者对象
        Statement stat = con.createStatement();
//        5.执行sql语句，并且接受结果
        String sql = "SELECT*FROM english0001";
        ResultSet rs = stat.executeQuery(sql);
//      6.处理结果
        while (rs.next()) {
            System.out.println(rs.getString("id") + "\t" + rs.getString("name"));
        }
//      7.释放资源
        rs.close();
        stat.close();
        con.close();
    }
}