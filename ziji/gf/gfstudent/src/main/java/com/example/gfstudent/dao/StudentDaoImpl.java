package com.example.gfstudent.dao;

import com.example.gfstudent.daomain.Student;
import com.example.gfstudent.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao{
    //查询所有学生信息
    @Override
    public ArrayList<Student> findAll() throws SQLException {
        ArrayList<Student> list=new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "SELECT*FROM student.student";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            int age = rs.getInt("age");
            int studentid = rs.getInt("studentid");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
           String identitycard = rs.getString("identitycard");
           String img=rs.getString("img");
            Student stu = new Student(id,name,gender,age,studentid,phone,email,identitycard,img);
            list.add(stu);
        }
        JDBCUtils.close(con,stat,rs);
        return list;
    }
    //条件查询，根据id查询学生信息
    @Override
    public Student findByid(Integer id) throws SQLException {
        Student stu=new Student();
        Connection con =JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "SELECT*FROM student.student WHERE id='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            int sid = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            int age = rs.getInt("age");
            int studentid = rs.getInt("studentid");
           String phone = rs.getString("phone");
            String email = rs.getString("email");
            String identitycard = rs.getString("identitycard");
            stu.setId(sid);
            stu.setName(name);
            stu.setGender(gender);
            stu.setAge(age);
            stu.setStudentid(studentid);
            stu.setPhone(phone);
            stu.setEmail(email);
            stu.setIdentitycard(identitycard);
        }
        JDBCUtils.close(con,stat,rs);
        return stu;
    }
    //添加学生信息
    @Override
    public int insert(Student stu) throws SQLException {
        int result=0;
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
//        String sql = "INSERT INTO student.student VALUES ('"+stu.getId()+"','"+stu.getName()+"','"+stu.getGender()+"','"+stu.getAge()+"','"+stu.getStudentid()+"','"+stu.getPhone()+"','"+stu.getEmail()+"','"+stu.getIdentitycard()+"','"+null+"')";
        String sql = "INSERT INTO student.student VALUES (null,'"+stu.getName()+"','"+stu.getGender()+"','"+stu.getAge()+"','"+stu.getStudentid()+"','"+stu.getPhone()+"','"+stu.getEmail()+"','"+stu.getIdentitycard()+"','"+null+"')";
//
        result=stat.executeUpdate(sql);
        JDBCUtils.close(con,stat);
        return result;
    }
    //修改学生信息
    @Override
    public int update(Student stu) throws SQLException {
        int result=0;
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "UPDATE student.student SET id='"+stu.getId()+"',name='"+stu.getName()+"',gender='"+stu.getGender()+"',age='"+stu.getAge()+"',studentid='"+stu.getStudentid()+"',phone='"+stu.getPhone()+"',email='"+stu.getEmail()+"',identitycard='"+stu.getIdentitycard()+"' WHERE id='"+stu.getId()+"'";
        result=stat.executeUpdate(sql);
        JDBCUtils.close(con,stat);
        return result;
    }
//删除学生
    @Override
    public int delete(Integer id) throws SQLException {
        int result=0;
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "DELETE FROM student.student WHERE id='"+id+"'";
        result=stat.executeUpdate(sql);
        JDBCUtils.close(con,stat);
        return result;
    }

}
