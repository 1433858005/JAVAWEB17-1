package com.heima.anli.dao;

import com.heima.anli.daomain.Student;
import com.heima.anli.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao {
    //查询所有学生信息
    @Override
    public ArrayList<Student> findAll() throws SQLException {
        ArrayList<Student> list=new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "SELECT*FROM student.student";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            Integer sid = rs.getInt("sid");
            String name = rs.getString("name");
            Integer age = rs.getInt("age");
            Date birthday = rs.getDate("birthday");
            Student stu = new Student(sid, name, age, birthday);
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
        String sql = "SELECT*FROM student.student WHERE sid='"+id+"'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            Integer sid = rs.getInt("sid");
            String name = rs.getString("name");
            Integer age = rs.getInt("age");
            Date birthday = rs.getDate("birthday");
           stu.setSid(sid);
           stu.setName(name);
           stu.setAge(age);
           stu.setBirthday(birthday);
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
        Date d=stu.getBirthday();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(d);
        String sql = "INSERT INTO student VALUES (' "+stu.getSid()+"','"+stu.getName()+"','"+stu.getAge()+"','"+birthday+"')";
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
        Date d=stu.getBirthday();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(d);
        String sql = "UPDATE student SET sid='"+stu.getSid()+"',name='"+stu.getName()+"',age='"+stu.getAge()+"',birthday='"+birthday+"' WHERE sid='"+stu.getSid()+"'";
        result=stat.executeUpdate(sql);
        JDBCUtils.close(con,stat);
        return result;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        int result=0;
        Connection con = JDBCUtils.getConnection();
        Statement stat = con.createStatement();
        String sql = "DELETE FROM student.student WHERE sid='"+id+"'";
        result=stat.executeUpdate(sql);
        JDBCUtils.close(con,stat);
        return result;
    }
}
