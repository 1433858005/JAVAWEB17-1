import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class a {
    public static void main(String[] args) {
        ArrayList<String> collection=new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        //在此集合中的指定位置插入指定的元素
        collection.add(0,"4");
        
        Iterator<String> iterator = collection.iterator();
        //遍历集合
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
