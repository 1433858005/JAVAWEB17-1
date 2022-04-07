package service;


import dao.StudentDao;
import dao.StudentDaoImpl;
import daomain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao=new StudentDaoImpl();
    //查询所有学生信息
    @Override
    public ArrayList<Student> findAll() throws SQLException {
        return dao.findAll();
    }
    //查根据id查询学生信息
    @Override
    public Student findByid(Integer id) throws SQLException {
        return dao.findByid(id);
    }
    //添加学生信息
    @Override
    public int insert(Student stu) throws SQLException {
        return dao.insert(stu);
    }
    //删除学生信息
    @Override
    public int update(Student stu) throws SQLException {
        return dao.update(stu);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return dao.delete(id);
    }
}
