//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class d {
//    public static void main(String[] args) {
//        TreeSet<Student> set=new TreeSet<>();
//       Student s1=new Student("小花",28);
//       Student s2=new Student("小花花",27);
//       Student s3=new Student("小小花",29);
//       Student s4=new Student("小黑",28);
//       Student s5=new Student("白黑",28);
//       set.add(s1);
//       set.add(s2);
//       set.add(s3);
//       set.add(s4);
//       set.add(s5);
//        System.out.println(s1);
//        System.out.println(set);
//    }
//}
//class Student implements Comparable<Student>{
//    private String name;
//    private  int age;
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public Student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//
//
//    @Override
//    public int compareTo(Student o) {
//        //按照对象的年龄进行排序
//        int i = this.age - o.age;
//        //i==0代表年龄相同，则进行名字判断
//        int ii = i == 0 ? this.name.compareTo(o.getName()) : i;
//        return ii;
//    }
//}
