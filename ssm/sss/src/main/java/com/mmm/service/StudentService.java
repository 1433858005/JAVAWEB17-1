package com.mmm.service;

import com.mmm.entity.Student;

import java.util.List;


//StudentService:底下需要去实现，调用dao层
public interface StudentService {
    //增加一位学生
    int addStudent(Student student);
    int deleteStudentById(int id);
    //根据id删除一位学生
    //更新Student
    int updateStudent(Student student);
    //根据id查询,返回一位学生
    Student queryStudentById(int id);
    //查询全部Student,返回list集合
    List<Student> queryAllStudent();
}
