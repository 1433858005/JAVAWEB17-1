package dao;


import daomain.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDao {
    //查询所有学生信息
    public abstract ArrayList<Student> findAll() throws SQLException;
    //条件查询，根据ID获取学生信息
    public abstract Student findByid(Integer id) throws SQLException;
    //新增学生信息
    public abstract int insert (Student stu) throws SQLException;
    //修改学生信息
    public abstract int update (Student stu) throws SQLException;
    //删除学生信息
    public abstract int delete (Integer id) throws SQLException;
}
