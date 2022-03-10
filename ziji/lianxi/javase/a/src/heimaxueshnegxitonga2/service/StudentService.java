package heimaxueshnegxitonga2.service;

import heimaxueshnegxitonga1.dao.StudentDao;
import heimaxueshnegxitonga1.domain.Student;

import java.util.Objects;

public class StudentService {
    //创建StudentDao(库管)
  private   StudentDao studentDao =new StudentDao();
    public boolean addStudent(Student stu) {
         //创建StudentDao(库管)
//        StudentDao studentDao=new StudentDao();
        //将学生对象，传递给StudentDao 库管中的addStudent方法
        //将返回的boolean类型结果，返还给StudenrController
        return  studentDao.addStudent(stu);
    }
//判断id是否被占用
    public boolean isExists(String id) {
        // studentDao.findAllStudent()返回学生类对象数组
      Student[] stus=  studentDao.findAllStudent();

      //假设id在数组中不存在
       boolean exists=false;
       //遍历数组，获取每一个学生对象，准备进行判断
        for (int i = 0; i < stus.length; i++) {
            //把学生对象传给student对象
            Student student=stus[i];
            if (student != null&& Objects.equals(student.getId(), id)){
                exists=true;//此时存在id占用
                break;
            }

        }

        return exists;//传Boolean类型判断id是否占用
    }
}




















