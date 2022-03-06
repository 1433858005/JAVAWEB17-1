package com.heima.anli.service;

import com.heima.anli.dao.StudentDao;
import com.heima.anli.dao.StudentDaoImpl;
import com.heima.anli.daomain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentServiceImpl implements StudentService{
    private StudentDao dao=new StudentDaoImpl();
    //查询所有学生信息
    @Override
    public ArrayList<Student> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Student findByid(Integer id) throws SQLException {
        return dao.findByid(id);
    }
//添加学生信息
    @Override
    public int insert(Student stu) throws SQLException {
        return dao.insert(stu);
    }

    @Override
    public int update(Student stu) throws SQLException {
        return dao. update(stu);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return dao.delete(id);
    }
}
