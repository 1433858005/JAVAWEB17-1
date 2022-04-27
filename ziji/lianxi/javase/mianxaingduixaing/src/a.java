//1.创建一个成员内部类写内部类的方法，变量，在主方法中调运内部类的方法，变量
//2.成员内部类设为static
//3.成员内部类设为static,主方法也是static
//4.成员内部类设为private
//5.创建一个局部内部类写内部类的方法，变量，在主方法中调运内部类的方法，变量
//6.创建一个内部类原型模式,
//7.创建一个单个方法的形式匿名内部类
//8.创建一个多个方法的形式匿名内部类
public class a {
    public static void main(String[] args) {
//    需求实现  goSwimming();
//        优化前
//        goSwimming((int a,int b)->{
//            return a-b;
//        });
//        优化后
        goSwimming((a,b)->
           a-b
        );
    }
    public static void goSwimming(Swimming swimming){
        int swim = swimming.swim(6, 2);
        System.out.println(swim);
    }
}
interface Swimming{
   int swim(int a,int b);
}
