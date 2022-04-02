package heimaxueshnegxitonga2.dao;

import heimaxueshnegxitonga2.domain.Student;

public class StudentDao {
   //创建为5的学生数组，每个stus都存着student对象，属性有id，name，age，birthday
   private static Student[] stus=new Student[5];
    public boolean addStudent(Student stu) {
        //定义变量index为-1，假设数组已经全部存满，没有null元素
        int index=-1;
        //遍历数组取出每一个元素，判断是否为null
        for (int i = 0; i < stus.length; i++) {
            Student student=stus[i];
            if (student==null)
            {
                index=i;
                //如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
                break;
            }
        }
        //返回是否添加成功的boolean类型的状态
        if (index==-1){
           //装满了
            return false;
        }else {
            //没有装满，正常添加，返回TRUE
            stus[index]=stu;
            //****************************************
            System.out.println(stu.getId());
            System.out.println(index);
            System.out.println(stus[index].getId());
            return true;
        }
    }
//返回学生类对象数组
    public Student[] findAllStudent() {
        return stus;
    }
    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus[index]=null;
    }
    public int getIndex(String id){
        int index=-1;
        for (int i = 0; i < stus.length; i++) {
            heimaxueshnegxitonga2.domain.Student stu=stus[i];
            if (stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }
    public void updateStudent(String updateId, heimaxueshnegxitonga2.domain.Student student) {
        int index=getIndex(updateId);
        stus[index]=student;
    }
}
