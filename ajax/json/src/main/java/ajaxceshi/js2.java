package ajaxceshi;

import com.sun.mail.util.BASE64DecoderStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Base64;

//import static jdk.internal.net.http.Http2ClientImpl.getParameter;

@WebServlet("/aa")
public class js2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //没用，要get请求用这里
    }
    @lombok.SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String t1=req.getParameter("add");
        System.out.println(t1);
        // base64编码中使用了加号（+），而+在URL传递时会被当成空格
        String ph="C:\\Users\\14338\\Desktop\\1\\"+t1+".jpg";
        FileOutputStream c=new FileOutputStream(ph);
//        String[] aaa =req.getParameter("as").replaceAll(" ","+").split("base64,");
        String t2=req.getParameter("as").replaceAll(" ","+");
        String[] aaa =t2.split("base64,");
        byte[] base= Base64.getDecoder().decode(aaa[1]);
        c.write(base);
        c.close();
        String tplj="src/main/webapp/WEB-INF/tp/"+t1+".jpg";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "15149622693");
        Statement stat = con.createStatement();
        String sql = "INSERT INTO a (img)VALUES('"+t2+"')";
        stat.execute(sql);
//      6.处理结果
//        while (rs.next()) {
//            System.out.println(rs.getString("img"));
//        }
//      7.释放资源
//        rs.close();
        stat.close();
        con.close();
        resp.setContentType("text/html;charset=UTF-8");//设置输出的数据格式，给前端发送数据
        resp.getWriter().write(tplj);

    }
}
