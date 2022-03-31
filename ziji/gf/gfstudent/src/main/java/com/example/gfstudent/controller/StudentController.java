package com.example.gfstudent.controller;

import com.example.gfstudent.daomain.Student;
import com.example.gfstudent.service.StudentService;
import com.example.gfstudent.service.StudentServiceImpl;
import org.testng.annotations.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
@WebServlet("/a")
public class StudentController extends HttpServlet {

    private StudentService service=new StudentServiceImpl();
    //查询所有学生信息
    @Test
    public void findAll() throws SQLException {
        ArrayList<Student> list = service.findAll();
        for (Student stu :list){
            System.out.println(stu);
        }
    }
    //条件查询，根据id查询学生信息
    @Test
    public void findById() throws SQLException {
        Student stu= service.findByid(1);
        System.out.println(stu);

    }
    //添加学生
    @Test
    public void insert() throws SQLException {
        Student stu=new Student(2,"几点上课了","男",56,25,456,"1111","456");
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
        Student stu = service.findByid(5);
        stu.setName("周七七");
        service.update(stu);
        int result=service.update(stu);
        if (result!=0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
