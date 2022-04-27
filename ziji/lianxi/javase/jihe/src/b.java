import java.util.ArrayList;

public class b {
    public static void main(String[] args) {
     w<String> a=new w<>();
     a.show("66666");
     w2 aa=new w2();
     aa.show(22);
    }
}
interface q<E>{
    public abstract void show(E e);
}
class w<E> implements q<E>{
    @Override
    public void show(E e) {
        System.out.println(e);
    }
}
class w2 implements q<Integer>{
    @Override
    public void show(Integer integer) {
        System.out.println(integer);
    }
}


