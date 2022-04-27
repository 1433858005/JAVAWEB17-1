import redis.clients.jedis.Jedis;

import java.util.List;

public class a {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("49.234.100.182",6379);
        //写入数据
//        jedis.set("aa","666");
        //获取数据
        String bb = jedis.get("bb");
        System.out.println(bb);
        //list方式
        jedis.lpush("list1", "a","b","c");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        jedis.close();
    }
}
