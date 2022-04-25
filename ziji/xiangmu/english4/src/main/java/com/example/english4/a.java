package com.example.english4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
@ResponseBody
public class a {
    @Autowired
    private EnglishMapper englishMapper;
    @RequestMapping("/s")
    public String save(){
        List<english> list=englishMapper.findAll("english0002");
        System.out.println(list);
        return "list1";
    }

    @RequestMapping("/a")
    public String save2() throws JsonProcessingException {
        List<String> list=englishMapper.findAll2();
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }

    @RequestMapping("/b")
    public String save3(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("username");
        System.out.println(a);
        String [] aa=a.split(",");
        englishMapper.se(aa[0],aa[1],aa[2]);
        return "单词---"+aa[1]+"---翻译---"+aa[2]+"---添加成功！在"+aa[0];
    }
    @RequestMapping("/main")
    public String save4() throws JsonProcessingException {
        Integer all = englishMapper.findAll3();
        System.out.println( englishMapper.findAll3());
        int b=new Random().nextInt(all)+1;//随机单词的id
        List<english> list = englishMapper.findAll4(b);
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }


}