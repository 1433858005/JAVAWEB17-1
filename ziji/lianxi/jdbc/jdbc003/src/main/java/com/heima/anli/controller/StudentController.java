package com.heima.anli.controller;

import com.heima.anli.daomain.Student;
import com.heima.anli.service.StudentService;
import com.heima.anli.service.StudentServiceImpl;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class StudentController {
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
        Student stu= service.findByid(3);
        System.out.println(stu);

    }
    @Test
    public void insert() throws SQLException {
        Student stu=new Student(5,"几点上课了",27,new Date());
        int result= service.insert(stu);
        if (result!=0){
            System.out.println("添加成功了");
        }else {
            System.out.println("添加失败了");
        }
    }
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
    @Test
    public void delete() throws SQLException {
        int result = service.delete(5);
        if (result!=0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

}













