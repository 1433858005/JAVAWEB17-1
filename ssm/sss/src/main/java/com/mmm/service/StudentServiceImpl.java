package com.mmm.service;

import com.mmm.dao.StudentMapper;
import com.mmm.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }
    @Override
    public int updateStudent(Student students) {
        return studentMapper.updateStudent(students);
    }
    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }
    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }
}
