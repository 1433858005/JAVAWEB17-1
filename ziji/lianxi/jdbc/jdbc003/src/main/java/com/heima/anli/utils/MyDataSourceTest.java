package com.heima.anli.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDataSourceTest {
    public static void main(String[] args) throws SQLException {
        //1创建连建池对象
        MyDataSource dataSource=new MyDataSource();
        System.out.println("使用之前的数量:"+dataSource.getSize());
        //2.查询连接池对象获取连接对象
        Connection con= dataSource.getConnection();
         //3查询学生表的全部信息
        String sql="SELECT * FROM student.student";
        PreparedStatement pst= con.prepareStatement(sql);
         //4执行sql语句，接收结果集
        ResultSet rs=pst.executeQuery();
        //5处理结果
      while (rs.next()){
          System.out.println(rs.getInt("sid")+rs.getString("name")+rs.getInt("age")+rs.getDate("birthday"));
      }
         //6.释放资源
      rs.close();
      pst.close();
      con.close();
        System.out.println("使用之后的数量:"+dataSource.getSize());
    }
}
