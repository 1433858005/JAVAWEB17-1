package com.mmm.dao;

import com.mmm.entity.Student;

import java.util.List;

public interface StudentMapper {
    //增加一位学生
    int addStudent(Student name);
    //根据id删除一位学生
    int deleteStudentById(int id);
    //更新Student
    int updateStudent(Student students);
    //根据id查询,返回一位学生
    Student queryStudentById(int id);
    //查询全部Book,返回list集合
    List<Student> queryAllStudent();
}
