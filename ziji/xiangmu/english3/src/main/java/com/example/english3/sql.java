package com.example.english3;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Mapper
@Repository
public class sql {
    public static void main(String[] args) throws SQLException {
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/english", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String sql = "INSERT INTO english.english0001 VALUES (null,'124','123')";
//        String sql = "INSERT INTO student.student VALUES (null,'"+stu.getName()+"')";
//        ResultSet rs =stat.executeQuery(sql);

//        int rs =stat.executeUpdate(sql);
//        ArrayList<String> aa=new ArrayList<>();
//        while(rs.next()){
//            aa.add(rs.getString(1));
////            System.out.println(rs.getString(1));
//        }
//        System.out.println(aa);
        stat.execute(sql);
        stat.close();
        con.close();
    }
}
