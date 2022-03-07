package com.example.http;
//package com.example.http;//package com.example.http;
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
import java.util.Objects;
import java.util.Random;

import static com.example.dao.dao01.*;

@WebServlet("/a")
public class a extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String shangyige=req.getParameter("shangyige");
        String[] cc =shangyige.split(",");
        if (!Objects.equals(shangyige, "")) {
            int b= Integer.parseInt(cc[0]);
            String b1= String.valueOf(b);
            String ab="english."+cc[1];

            //当前数据库单词总数，随机单词位置，随机单词，翻译，
            String shuju=allid(ab)+","+b1+","+getname(ab,b)+","+ getfanyi(ab,b);
            resp.getWriter().write(shuju);
//            System.out.println(66666);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
