package heimaxueshnegxitonga3.entry;

import heimaxueshnegxitonga2.controller.StudentController;

import java.util.Scanner;

public class InfoMangerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("黑马信息管理系统");
            System.out.println("请输入你的选择：1.学生管理 2.老师管理 3.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("学生管理");
                    StudentController studentController=new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("老师管理");
                    break;
                case "3":
                    System.out.println("感谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，重新输入");
                    break;
            }
        }
    }
}
