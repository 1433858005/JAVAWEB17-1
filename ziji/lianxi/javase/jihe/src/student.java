import java.util.Objects;

public class student {
    private String name;
    private  int age;

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//重写了hashCode方法,一般都是通过对象的属性值计算出哈希值。
//如果不同的对象属性值是一样的,那么计算出来的哈希值也是一样的。
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        student student = (student) o;
//        return age == student.age && Objects.equals(name, student.name);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
