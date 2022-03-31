package com.example.gfstudent.controller;

import com.example.gfstudent.daomain.Student;
import com.example.gfstudent.service.StudentService;
import com.example.gfstudent.service.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
@WebServlet("/a")
public class StudentController extends HttpServlet {
    @lombok.SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username=req.getParameter("username");
        StudentService service=new StudentServiceImpl();
        ObjectMapper mapper=  new ObjectMapper();
        //查询所有学生信息
        ArrayList<Student> list = service.findAll();
        //json List<Student>转JSON
        String json =mapper.writeValueAsString(list);
        System.out.println(json);
        if(username.equals("1")){
            System.out.println(111);
            resp.getWriter().write(json);
            System.out.println(6666);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private StudentService service=new StudentServiceImpl();
    ObjectMapper mapper=  new ObjectMapper();
    //查询所有学生信息
    @Test
    public void findAll() throws SQLException, JsonProcessingException {
        ArrayList<Student> list = service.findAll();
        //json List<Student>转JSON
        String json =mapper.writeValueAsString(list);
        System.out.println(json);

//        for (Student stu :list){
//
////            System.out.println(stu);
//        }

    }
    //条件查询，根据id查询学生信息
    @Test
    public void findById() throws SQLException, JsonProcessingException {
        Student stu= service.findByid(2);
//        System.out.println(stu);
//        User user =new User("张三",23);
        String json = mapper.writeValueAsString(stu);
        System.out.println(json);
    }
    //添加学生
    @Test
    public void insert() throws SQLException {
        Student stu=new Student(4,"几点上课了","男",56,25,456,"1111","456");
        int result= service.insert(stu);
        if (result!=0){
            System.out.println("添加成功了");
        }else {
            System.out.println("添加失败了");
        }
    }
    //根据id修改学生信息
    @Test
    public void update() throws SQLException {
        Student stu = service.findByid(1);
        stu.setName("周七七");
        stu.setGender("女");
        service.update(stu);
        int result=service.update(stu);
        if (result!=0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
    @Test
    public void delete() throws SQLException {
        int result = service.delete(1);
        if (result!=0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }



}
