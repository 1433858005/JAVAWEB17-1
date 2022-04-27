import java.util.*;

public class e {
    public static void main(String[] args) {
        TreeMap<student,String> aa=new TreeMap<>(
                new Comparator<student>() {
                    @Override
                    public int compare(student o1, student o2) {
                        int i=o1.getAge()-o2.getAge();
                        i=i==0?o1.getName().compareTo(o2.getName()):i;
                        return i;
                    }
                }
        );
        student a=new student("zhnagsan",26);
        student b=new student("lisi",24);
        student c=new student("lisi2",24);
        aa.put(a, "上海");
        aa.put(b, "西藏");
        aa.put(c, "新疆");
        //第一种方式遍历
        Set<student> key = aa.keySet();
        for (student s : key) {
            System.out.println(s+aa.get(s));
        }
        //第二种方式遍历
        Set<Map.Entry<student, String>> set = aa.entrySet();
        for (Map.Entry<student, String> entry : set) {
            System.out.println(entry.getKey()+entry.getValue());
        }
        //第三种方式遍历
        aa.forEach((student aaa,String value)->{
            System.out.println(aaa+value);
        });
    }
}
