package com.example.dao;
import java.sql.*;
import java.util.Random;


public class dao01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //方法根据id获取name
         getname(2);
       //  方法根据id获取翻译
        getfanyi(2);
      //  随机生成id，最大为数据库id最大值
        allid();  //id最大值
        int b=new Random().nextInt(allid())+1;
        System.out.println("随机id**"+b);

    }

    public static int allid() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english", "root", "15149622693");
        Statement stat = con.createStatement();
        int allid=0;
        String sql = "SELECT*FROM english.english0001 ORDER BY  id DESC LIMIT 1";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
         System.out.println(rs.getInt("id"));
         allid=rs.getInt("id");
        }
        rs.close();
        stat.close();
        con.close();
        return allid;
    }

    public static String getname(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english", "root", "15149622693");
        Statement stat = con.createStatement();
        String   name = null;
        String sql = "SELECT*FROM english.english0001 WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            name=rs.getString("name");
        }
        rs.close();
        stat.close();
        con.close();
        return name;
    }
    public static String getfanyi(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english", "root", "15149622693");
        Statement stat = con.createStatement();
        String   name = null;
        String sql = "SELECT*FROM english.english0001 WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("fanyi"));
            name=rs.getString("fanyi");
        }
        rs.close();
        stat.close();
        con.close();
        return name;
    }
}
