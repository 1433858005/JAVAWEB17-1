package com.mmm.controller;


import com.mmm.entity.Student;
import com.mmm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    @RequestMapping("/allStudent")
    public String list(Model model){
        List<Student> list =studentService.queryAllStudent();
        model.addAttribute("list", list);
        return "allStudent";
    }
    @RequestMapping("/toAddStudent")
    public String toAddPaper(){
        return "addStudent";
    }
    @RequestMapping("/addSetudent")
    public String addPaper(Student student){
        System.out.println(student);
        studentService.addStudent(student);
        return "redirect:/student/allStudent";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateSudent(Model model, int id) {
        Student student = studentService.queryStudentById(id);
        System.out.println(student);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateBook(Model model, Student student) {
        System.out.println(student);
        studentService.updateStudent(student);
        Student student1 = studentService.queryStudentById(student.getId());
        model.addAttribute("student", student1);
        return "redirect:/student/allStudent";
    }

    @RequestMapping("/del/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/allStudent";
    }

}
