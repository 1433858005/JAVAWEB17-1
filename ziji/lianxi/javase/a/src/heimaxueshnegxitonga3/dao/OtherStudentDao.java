package heimaxueshnegxitonga3.dao;


import heimaxueshnegxitonga3.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao {
    //创建为5的学生数组，每个stus都存着student对象，属性有id，name，age，birthday
//    private static Student[] stus=new Student[5];
    private static ArrayList<Student> stus=new ArrayList<>();
    public boolean addStudent(Student stu) {
         stus.add(stu);
         return true;
        }

    //返回学生类对象数组
    public Student[] findAllStudent() {
        Student[] s=new Student[stus.size()];
        for (int i = 0; i < s.length; i++) {
            s[i]=stus.get(i);
        }
        return s;
    }
    public void updateStudent(String updateId, heimaxueshnegxitonga3.domain.Student student) {
        int index=getIndex(updateId);
        stus.set(index,student);

    }
    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
       stus.remove(index);
    }
    public int getIndex(String id){
        int index=-1;
        for (int i = 0; i < stus.size(); i++) {
            heimaxueshnegxitonga3.domain.Student stu=stus.get(i);
            if (stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }
}
