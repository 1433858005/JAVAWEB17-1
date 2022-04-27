import java.util.ArrayList;

public class c {
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Number>  b=new ArrayList<>();
        ArrayList<Object>  c=new ArrayList<>();
        add(a);
        add(b);
//        add(c);//不能用c
//        add2(a);//不能用a
        add2(b);
        add2(c);
    }
    private static void add(ArrayList<?extends Number> list) {
     ////表示传递进来集合的类型,可以是Number类型,也可以是Number所有的子类类型
    }
    private static void add2(ArrayList<?super Number> list) {
////表示传递进来集合的类型,可以是Number类型,也可以是Numbe让所有的父类类型
    }
}
