package arraylist;

import java.util.ArrayList;
import java.util.Collections;

//测试功能（要求不能创建String字符串）
//        创建一个arraylist集合，依次添加张三，李四，王五，添加赵六到第一个位置，
//        修改张三为王五，删除李四并判断是否成功，打印集合元素
//        结果为
//        true
//        zhaoliu
//        wangwu
//        wangwu
public class a {
    public static void main(String[] args) {
        ArrayList<String> b=new ArrayList<>();
        b.add("张三");
        b.add("李四");
        b.add("王五");
        b.add(0,"赵六");
        b.set(1,b.get(3));
        boolean remove = b.remove("李四");
        System.out.println(remove);
        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i));
        }

    }


}
