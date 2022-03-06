package com.example.http;//package com.example.http;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

import static com.example.dao.dao01.*;

@WebServlet("/aa")
public class servicehttp extends HttpServlet {


    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username=req.getParameter("username");
        if (username.equals("aa")) {
            int b=new Random().nextInt(allid())+1;
        //当前数据库单词总数，随机单词位置，随机单词，翻译，
            resp.getWriter().write(b+getname(b));
            System.out.println(888888);
            //功能，.1.修改翻译，
            //主要功能，指定数据库页添加收藏单词，id，name，fanyi。
            //进行指定数据库单词，
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
