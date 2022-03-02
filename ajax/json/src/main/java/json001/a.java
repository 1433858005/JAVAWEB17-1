package json001;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

//json转换工具
public class a {
    ObjectMapper mapper=  new ObjectMapper();
    @Test
    public void  test01() throws Exception {
        //User对象转json
       User user =new User("张三",23);
        String json = mapper.writeValueAsString(user);
        System.out.println("java字符串:"+json);
        //json转User对象
        User user2= mapper.readValue(json,User.class);
        System.out.println("java对象:"+ user2.getAge());
        //java字符串:{"name":"张三","age":23}
        //java对象:23
    }
    @Test
    public void  test02() throws Exception {
        //map<String ,String>转json
        HashMap<String,String> map =new HashMap<>();
        map.put("姓名","张三");
        map.put("性别","男");
        String json =mapper.writeValueAsString(map);
        System.out.println("json字符串:"+json);
        //json转map<String,String>
        HashMap<String,String> map2=mapper.readValue(json,HashMap.class);
        System.out.println("java对象:"+map2);
        //json字符串:{"姓名":"张三","性别":"男"}
        //java对象:{姓名=张三, 性别=男}
    }
    @Test
    public void  test03() throws Exception {
    //map<String,User>转json
        HashMap<String,User> map=new HashMap<>();
        map.put("黑马一班",new User("张三",23));
        map.put("黑马二班",new User("李四",23));
        String json=mapper.writeValueAsString(map);
        System.out.println("json字符串"+json);
        //json转map<String,User>
        HashMap<String,User> map2=mapper.readValue(json,new TypeReference<HashMap<String,User>>(){});
        System.out.println("java对象"+map2);
        //json字符串{"黑马二班":{"name":"李四","age":23},"黑马一班":{"name":"张三","age":23}}
        //java对象{黑马二班=json001.User@2c35e847, 黑马一班=json001.User@7bd4937b}
    }
    @Test
    public void  test04() throws Exception {
        //List <String>转json
        ArrayList<String> list =new ArrayList<>();
        list.add("张三");
        list.add("李四");
        String json=mapper.writeValueAsString(list);
        System.out.println("json字符串"+json);
        //json转List<String>
        ArrayList<String> list2=mapper.readValue(json,ArrayList.class);
        System.out.println("java对象："+list2);
        //json字符串["张三","李四"]
        //java对象：[张三, 李四]
    }
    @Test
    public void  test05() throws Exception {
            //LIst<User>转json
        ArrayList<User> list =new ArrayList<>();
        list.add(new User("11",23));
        list.add(new User("11",23));
        String json =mapper.writeValueAsString(list);
        System.out.println("json字符串"+json);
        //json转List<User>
        ArrayList<User> list2 =mapper.readValue(json, new TypeReference<ArrayList<User>>() {});
        System.out.println("java对象："+list2);
        //json字符串[{"name":"11","age":23},{"name":"11","age":23}]
        //java对象：[json001.User@20ccf40b, json001.User@2fb3536e]
    }
}
