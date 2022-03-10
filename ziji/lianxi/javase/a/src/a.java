import java.util.ArrayList;

public class a {
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<>();
        a.add("zhangsan");
        a.add("lisi");
        a.add("wangwu");
        a.add(0,"zhaoliu");
        a.set(1,a.get(3));
        System.out.println(a.remove(a.get(2)));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }
}
