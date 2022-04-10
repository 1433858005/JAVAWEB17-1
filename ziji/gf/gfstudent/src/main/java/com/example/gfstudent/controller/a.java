//package com.example.gfstudent.controller;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class a {
//    public static void main(String[] args) throws Exception {
//        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/student", "root", "Jp15149622693");
//        Statement stat = con.createStatement();
////        String sql = "INSERT INTO student.student VALUES ('"+null+"','"+"男"+"','"+null+"','"+11+"','"+22+"','"+33+"','"+null+"','"+null+"','"+null+"')";
//        String sql = "INSERT INTO student.student1 VALUES (null,'"+"男"+"','"+4+"')";
////        String sql = "INSERT INTO student.student1 VALUES (null,'qw',4)";
//        stat.execute(sql);
//        stat.close();
//        con.close();
//    }
//}