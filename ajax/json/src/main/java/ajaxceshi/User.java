package ajaxceshi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public static void main(String[] args) throws Exception {
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/aa", "root", "15149622693");
        Statement stat = con.createStatement();
//        String sql = "INSERT INTO a (img)VALUES('"+"66666"+"')";
//        String sql = "SELECT img FROM a";
//        String sql = "SELECT img FROM a";
        String sql = "SELECT*FROM a limit 3";
        ResultSet rs = stat.executeQuery(sql);
//      6.处理结果
        while (rs.next()) {
            System.out.println(rs.getString("img"));
        }
//      7.释放资源
        rs.close();
        stat.close();
        con.close();
    }
}