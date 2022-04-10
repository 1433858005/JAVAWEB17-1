//package com.example.gfstudent.controller;
//
//import com.example.gfstudent.utils.JDBCUtils;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//public class b {
//    public static void main(String[] args) throws SQLException {
////        ArrayList<Student> list=new ArrayList<>();
//        Connection con = JDBCUtils.getConnection();
//        Statement stat = con.createStatement();
//        String sql = "SELECT*FROM student.student";
//        ResultSet rs = stat.executeQuery(sql);
//        while (rs.next()) {
//            Integer sid = rs.getInt("id");
//            String name = rs.getString("name");
//            Integer age = rs.getInt("age");
////            Date birthday = rs.getDate("birthday");
//            System.out.println(sid);
//            System.out.println(name);
//            System.out.println(age);
////            Student stu = new Student(sid, name, age, birthday);
////            list.add(stu);
//        }
////        JDBCUtils.close(con,stat,rs);
////        for (Student stu :list){
////            System.out.println(stu);
////        }
//    }
//}
