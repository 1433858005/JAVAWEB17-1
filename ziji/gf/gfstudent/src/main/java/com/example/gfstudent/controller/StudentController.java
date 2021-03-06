package com.example.gfstudent.controller;

import com.example.gfstudent.daomain.Student;
import com.example.gfstudent.service.StudentService;
import com.example.gfstudent.service.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
//访问到a则接受数据
@WebServlet("/a")
public class StudentController extends HttpServlet {
    @lombok.SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     //设置接受发送字符类型utf-8
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//      //  service对象,调用StudentServiceImpl方法
//        StudentService service=new StudentServiceImpl();
//        //mapper对象，json转换用
//        ObjectMapper mapper=  new ObjectMapper();
////接收username认证，给前端传所有数据
//        if(req.getParameter("username")!=null){  //防止数据误传
//            String username=req.getParameter("username");
//            //查询所有学生信息
//            ArrayList<Student> list = service.findAll();
//            //json List<Student>转JSON
//            String json =mapper.writeValueAsString(list);
////            System.out.println(json);
//          //前端传数据==1则给前端传json
//            if(username.equals("1")){
//                resp.getWriter().write(json);
//            }
//        }
////添加
//        if(req.getParameter("add")!=null) {
//            String add = req.getParameter("add");
//            //添加学生
//                String[] a = add.split(",");
//            for (int i = 0; i < a.length; i++) {
//                System.out.println(a[i]);
//            }
//                //stu对象，传入各个学生属性值
//            Student stu=new Student(0,a[0],a[1],Integer.parseInt(a[2]),Integer.parseInt(a[3]),a[4],a[5],a[6],null);
//        //传给insert方法 值stu ，返回result，0添加为成功，否则失败
//            int result= service.insert(stu);
//            if (result!=0){
//                resp.getWriter().write("添加成功了");
//                System.out.println("添加成功了");
//            }else {
//                resp.getWriter().write("添加失败了");
//                System.out.println("添加失败了");
//            }
//        }
//        //删除
//        if(req.getParameter("deletes")!=null) {
//            String delete= req.getParameter("deletes");
//            int result = service.delete(Integer.parseInt(delete));
//            if (result!=0){
//                resp.getWriter().write("删除成功");
//                System.out.println("删除成功");
//            }else {
//                resp.getWriter().write("删除失败");
//                System.out.println("删除失败");
//            }
//        }
//        //根据id修改
//        if(req.getParameter("update")!=null) {
//            String update= req.getParameter("update");
////            ，切割字符串
//            String[] a = update.split(",");
//
//            Student stu = service.findByid(Integer.parseInt(a[0]));
//            stu.setName(a[1]);
//            stu.setGender(a[2]);
//            stu.setAge(Integer.parseInt(a[3]));
//            stu.setStudentid(Integer.parseInt(a[4]));
//            stu.setPhone(a[5]);
//            stu.setEmail(a[6]);
//            stu.setIdentitycard(a[7]);
//            service.update(stu);
//            int result=service.update(stu);
//            if (result!=0){
//                resp.getWriter().write("修改成功");
//                System.out.println("修改成功");
//            }else {
//                resp.getWriter().write("修改失败");
//                System.out.println("修改失败");
//            }
//        }


    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //doPost上传图片，base64的形式
//        req.setCharacterEncoding("UTF-8");
//        String t1=req.getParameter("add");
//        System.out.println(t1);
//        // base64编码中使用了加号（+），而+在URL传递时会被当成空格
//        String t2=req.getParameter("as").replaceAll(" ","+");
//        //连接数据库 练习jdbc形式
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con =  DriverManager.getConnection("jdbc:mysql://gz-cynosdbmysql-grp-i4doar87.sql.tencentcdb.com:25769/student", "root", "Jp15149622693");
//
//        Statement stat = con.createStatement();
//        String sql = "UPDATE student.student SET img='"+t2+"' WHERE id='"+t1+"'";
//        stat.execute(sql);
//        stat.close();
//        con.close();
//        resp.setContentType("text/html;charset=UTF-8");//设置输出的数据格式，给前端发送数据
//        resp.getWriter().write("添加成功");
        //设置接受发送字符类型utf-8
        //***************************************************************************

        //******************************************************************************
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //  service对象,调用StudentServiceImpl方法
        StudentService service=new StudentServiceImpl();
        //mapper对象，json转换用
        ObjectMapper mapper=  new ObjectMapper();
//接收username认证，给前端传所有数据
        if(req.getParameter("username")!=null){  //防止数据误传
            String username=req.getParameter("username");
            //查询所有学生信息
            ArrayList<Student> list = service.findAll();
            //json List<Student>转JSON
            String json =mapper.writeValueAsString(list);
//            System.out.println(json);
            //前端传数据==1则给前端传json
            if(username.equals("1")){
                resp.getWriter().write(json);
            }
        }
//添加
        if(req.getParameter("add")!=null) {
            String add = req.getParameter("add");
            //添加学生
            String[] a = add.split(",");
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            //stu对象，传入各个学生属性值
            Student stu=new Student(0,a[0],a[1],Integer.parseInt(a[2]),Integer.parseInt(a[3]),a[4],a[5],a[6],null);
            //传给insert方法 值stu ，返回result，0添加为成功，否则失败
            int result= service.insert(stu);
            if (result!=0){
                resp.getWriter().write("添加成功了");
                System.out.println("添加成功了");
            }else {
                resp.getWriter().write("添加失败了");
                System.out.println("添加失败了");
            }
        }
        //删除
        if(req.getParameter("deletes")!=null) {
            String delete= req.getParameter("deletes");
            int result = service.delete(Integer.parseInt(delete));
            if (result!=0){
                resp.getWriter().write("删除成功");
                System.out.println("删除成功");
            }else {
                resp.getWriter().write("删除失败");
                System.out.println("删除失败");
            }
        }
        //根据id修改
        if(req.getParameter("update")!=null) {
            String update= req.getParameter("update");
//            ，切割字符串
            String[] a = update.split(",");

            Student stu = service.findByid(Integer.parseInt(a[0]));
            stu.setName(a[1]);
            stu.setGender(a[2]);
            stu.setAge(Integer.parseInt(a[3]));
            stu.setStudentid(Integer.parseInt(a[4]));
            stu.setPhone(a[5]);
            stu.setEmail(a[6]);
            stu.setIdentitycard(a[7]);
            service.update(stu);
            int result=service.update(stu);
            if (result!=0){
                resp.getWriter().write("修改成功");
                System.out.println("修改成功");
            }else {
                resp.getWriter().write("修改失败");
                System.out.println("修改失败");
            }
        }
    }

//    private StudentService service=new StudentServiceImpl();
//    ObjectMapper mapper=  new ObjectMapper();
//    //查询所有学生信息
//    @Test
//    public void findAll() throws SQLException, JsonProcessingException {
//        ArrayList<Student> list = service.findAll();
//        //json List<Student>转JSON
//        String json =mapper.writeValueAsString(list);
//        System.out.println(json);
//    }
//    //条件查询，根据id查询学生信息
//    @Test
//    public void findById() throws SQLException, JsonProcessingException {
//        Student stu= service.findByid(2);
////        System.out.println(stu);
////        User user =new User("张三",23);
//        String json = mapper.writeValueAsString(stu);
//        System.out.println(json);
//    }
//    //添加学生
//    @Test
//    public void insert() throws SQLException {
//        Student stu=new Student(0,"几点上课了","男",56,25,456,"1111","456","11");
//        int result= service.insert(stu);
//        if (result!=0){
//            System.out.println("添加成功了");
//        }else {
//            System.out.println("添加失败了");
//        }
//    }
//    //根据id修改学生信息
//    @Test
//    public void update() throws SQLException {
//        Student stu = service.findByid(1);
//        stu.setName("周七七");
//        stu.setGender("女");
//        service.update(stu);
//        int result=service.update(stu);
//        if (result!=0){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }
//    }
//    @Test
//    public void delete() throws SQLException {
//        int result = service.delete(1);
//        if (result!=0){
//            System.out.println("删除成功");
//        }else {
//            System.out.println("删除失败");
//        }
//    }
}
