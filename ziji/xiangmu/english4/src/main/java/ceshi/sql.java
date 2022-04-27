package ceshi;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Mapper
@Repository
public class sql {
    public static void main(String[] args) throws SQLException {
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/", "root", "Jp15149622693");
        Statement stat = con.createStatement();
        String sql = "SELECT*FROM english.english0001 ORDER BY id DESC LIMIT 1";
//        String sql = "INSERT INTO student.student VALUES (null,'"+stu.getName()+"')";
        ResultSet rs =stat.executeQuery(sql);

//        int rs =stat.executeUpdate(sql);
//        ArrayList<String> aa=new ArrayList<>();
        while(rs.next()){
//            aa.add(rs.getString(1));
            System.out.println(rs.getInt("id"));
        }
//        System.out.println(aa);
        stat.execute(sql);
        stat.close();
        con.close();
    }
}
