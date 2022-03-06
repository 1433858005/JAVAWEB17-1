package com.heima.anli.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //1.私有构造方法
    private JDBCUtils(){}
     //2.声明所需要的配置变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;
    // 3.提供静态代码块。读取配置文件的信息为变量赋值,注册驱动
    static {
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
            Properties prop=new Properties();
            prop.load(is);
            driverClass=prop.getProperty("driverClass");
            url=prop.getProperty("url");
            username=prop.getProperty("username");
            password=prop.getProperty("password");
            //注册驱动
            Class.forName(driverClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 4.提供获取数据库连接方法
public static Connection getConnection() throws SQLException {
        con= DriverManager.getConnection(url,username,password);

        return con;
}
    // 5,提供释放资源的方法
public static void close(Connection con, Statement stat, ResultSet rs) throws SQLException {
  if (con !=null){
      con.close();
  }
  if (stat !=null){
      con.close();
  }
  if (rs !=null){
      con.close();
  }
}
//方法重载
    //如果是查询功能调用第一个方法
    //如果是增删改调用第二个方法
    public static void close(Connection con, Statement stat) throws SQLException {
        if (con !=null){
            con.close();
        }
        if (stat !=null){
            con.close();
        }

    }
}
