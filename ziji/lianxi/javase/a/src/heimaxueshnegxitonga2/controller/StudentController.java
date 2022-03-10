package heimaxueshnegxitonga2.controller;

import heimaxueshnegxitonga1.domain.Student;
import heimaxueshnegxitonga1.service.StudentService;

import java.util.Scanner;

public class StudentController {
  private   StudentService studentService = new StudentService();
    //开启学生管理系统，并展示学生管理系统菜单
    public void start() {
        Scanner sc = new Scanner(System.in);
        a:
        while (true) {
            System.out.println("学生管理系统");
            System.out.println("请输入你的选择：1.添加学生 2.删除学生 3.修改学生 4.查看学生 5退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("退出学生管理系统，再见");
                    break a;
                default:
                    System.out.println("输入有误，重新输入");
                    break;
            }
        }
    }

    private void findAllStudent() {
        Student[] stus=studentService.findAllStudent();
        if (stus==null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号姓名年龄生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu=stus[i];
            if (stu!=null){
                System.out.println(stu.getId()+stu.getName()+stu.getAge()+stu.getBirthday());
            }
        }
    }

    public void addStudent() {

        Scanner sc = new Scanner(System.in);
        String id;
        //判断id是否被占用
        while (true){
            System.out.println("请输入学生id");
             id = sc.next();
        boolean flag=studentService.isExists(id);
//            System.out.println(flag);

        if (flag){
            System.out.println("学号以被占用，请重新输入");
        }else {
            break;
        }
        }

        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        //将学生信息封装为学生对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        //将学生对象传递给StudentService（业务员）中的addStudent方法

        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }
}
