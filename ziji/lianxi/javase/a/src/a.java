class student2 {
    String name;
    int age;
    static String school;
    public void show() {
        System.out.println(name + age + school);
    }
}

public class a {
    public static void main(String[] args) {
        student2 aa = new student2();
        aa.name = "张三";
        aa.age = 23;
        aa.school = "清华";
        aa.show();
        student2 bb = new student2();
        bb.show();
        //输出为张三23清华
        //  null0清华
    }
}