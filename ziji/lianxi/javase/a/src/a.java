class  fu{
    private  String name;
    private  int age;
    int num =10;
    public fu() {System.out.println("我是父类的空参构造方法");}
    public fu(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("我是父类带参构造方法");
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}

class  zi extends fu{
    private int  ddd;
    public zi(){ System.out.println("我是子类的空参构造方法..."); }
    public zi(int ddd) {
        //子类在初始化之前，一定要先完成父类数据的初始化.
//子类在初始化之前，一定要先访问到父类的构造方法完成父类数据的初始化
//系统在每一个构造方法中,默认隐藏的一句代码super();
        super();   //为访问父类的空参构造方法

        System.out.println(num);
        this.ddd = ddd;
        System.out.println("我是子类的带参构造方法...");
    }
    public int getDdd() {return ddd;}
    public void setDdd(int ddd) {this.ddd = ddd;}
}
public class a {
    public static void main(String[] args) {
        zi aa = new zi();
        zi bb = new zi(100);
    }
}