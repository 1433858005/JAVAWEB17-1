package com.example.gfstudent.controller;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/b")
public class call extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //doPost上传图片，base64的形式
        req.setCharacterEncoding("UTF-8");
        String t1=req.getParameter("add");
        System.out.println(t1);
        // base64编码中使用了加号（+），而+在URL传递时会被当成空格
        String t2=req.getParameter("as").replaceAll(" ","+");
        //连接数据库 练习jdbc形式
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/student", "root", "Jp15149622693");

        Statement stat = con.createStatement();
        String sql = "UPDATE student.student SET img='"+t2+"' WHERE id='"+t1+"'";
        stat.execute(sql);
        stat.close();
        con.close();
        resp.setContentType("text/html;charset=UTF-8");//设置输出的数据格式，给前端发送数据
        resp.getWriter().write("添加成功");
//        设置接受发送字符类型utf-8
    }
}
