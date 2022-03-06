package com.example.dao;
import com.example.http.servicehttp;

import java.sql.*;
public class dancidaompl {
    public static void main(String[] args) throws SQLException {
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/english", "root", "Jp15149622693");
        int id=1;
        String sql = "SELECT*FROM english.english ORDER BY  id DESC LIMIT 1";
        PreparedStatement stat =  con.prepareStatement(sql);
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }
        rs.close();
        stat.close();
        con.close();
    }

}
