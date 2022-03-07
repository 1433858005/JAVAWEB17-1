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
//        allid();  //id最大值
//        int b=new Random().nextInt(allid())+1;
//        System.out.println("随机id**"+b);
//      tianjia();
    }
    public static String tianjia(String a, int b, String c, String d) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
//        gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String sql = "INSERT INTO "+a+" VALUES ('"+b+"','"+c+"','"+d+"')";
        stat.execute(sql);
        stat.close();
        con.close();
        return "已添加到"+a+"表";
    }

    public static int allid(String a) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
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
//    public static String tianjia(int a, String b, String c) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver") ;
//        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english?useSSL=true&useUnicode=true&characterEncoding=utf8", "root", "15149622693");
//        Statement stat = con.createStatement();
//
//        String sql = "INSERT INTO english.english0002 VALUES ('"+a+"','"+b+"','"+c+"')";
////        String sql = "INSERT INTO english.english0002 VALUES ('"+"generated"+"','"+b+"','"+c+"')";
//        stat.execute(sql);
//        stat.close();
//        con.close();
//        return "已添加到english0002表";
//    }
//    public static int allid() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver") ;
//         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/english", "root", "15149622693");
//        Statement stat = con.createStatement();
//        int allid=0;
//        String sql = "SELECT*FROM english.english0001 ORDER BY  id DESC LIMIT 1";
//        ResultSet rs = stat.executeQuery(sql);
//        while (rs.next()) {
////         System.out.println(rs.getInt("id"));
//         allid=rs.getInt("id");
//        }
//        rs.close();
//        stat.close();
//        con.close();
//        return allid;
//    }
public static String getname(String a,int id) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver") ;
    Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
    Statement stat = con.createStatement();
    String   name = null;
    String sql = "SELECT*FROM "+a+" WHERE id='"+id+"'";
    ResultSet rs = stat.executeQuery(sql);
    while (rs.next()) {
//            System.out.println(rs.getString("name"));
        name=rs.getString("name");
    }
    rs.close();
    stat.close();
    con.close();
    return name;
}
    public static String getname(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String   name = null;
        String sql = "SELECT*FROM english.english0001 WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
//            System.out.println(rs.getString("name"));
            name=rs.getString("name");
        }
        rs.close();
        stat.close();
        con.close();
        return name;
    }

    public static String getfanyi(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String   name = null;
        String sql = "SELECT*FROM english.english0001 WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
//            System.out.println(rs.getString("fanyi"));
            name=rs.getString("fanyi");
        }
        rs.close();
        stat.close();
        con.close();
        return name;
    }
    public static String getfanyi(String a,int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String   name = null;
        String sql = "SELECT*FROM "+a+" WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
//            System.out.println(rs.getString("fanyi"));
            name=rs.getString("fanyi");
        }
        rs.close();
        stat.close();
        con.close();
        return name;
    }
}
