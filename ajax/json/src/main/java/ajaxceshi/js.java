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
import java.util.Base64;

@WebServlet("/a")
public class js extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //没用，要get请求用这里
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ServletInputStream inputStream = req.getInputStream();
//        inputStream.
        FileOutputStream c=new FileOutputStream("C:\\Users\\14338\\Desktop\\1\\99.jpg");
        byte[] arr=new byte[1024];
        int len;
        StringBuilder wen =new StringBuilder();
        while ((len=inputStream.read(arr))!=-1) {
            wen.append(new String(arr, 0, len));
        }
        String aq= wen.toString();

        //解码
        String[] aaa =aq.split("base64,");
        System.out.println(aaa[1]);
        byte[] base= Base64.getDecoder().decode(aaa[1]);
        c.write(base);
        inputStream.close();
        c.close();
        System.out.println(3);
        resp.setContentType("text/html;charset=UTF-8");//设置输出的数据格式，给前端发送数据
        resp.getWriter().write("666");
    }

}
