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

@WebServlet("/b")
//收藏功能
public class b extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String shoucang=req.getParameter("shoucang");
        if (!Objects.equals(shoucang, "")) {
            String[] cc =shoucang.split(",");
            String a1="english."+cc[2];
//            int a2= Integer.parseInt(cc[0]);
            int a2= allid(a1)+1 ;

            String aa=tianjia(a1,a2,cc[0],cc[1]);

            System.out.println(aa);
            resp.getWriter().write(aa);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
