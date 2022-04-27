import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f {
    public static void main(String[] args) {
        ArrayList<String> aa=new ArrayList<>();
        aa.add("张三,23");
        aa.add("李四,24");
        aa.add("王五,25");
        Map<String, Integer> map = aa.stream().filter(
                s -> {
                    String[] split = s.split(",");
                    int age = Integer.parseInt(split[1]);
                    return age >= 24;
                }
        ).collect(Collectors.toMap(
                (String s) -> {
                    return s.split(",")[0];
                }, (String s) -> {
                    return Integer.parseInt(s.split(",")[1]);
                }
        ));
        System.out.println(map);
    }
}
