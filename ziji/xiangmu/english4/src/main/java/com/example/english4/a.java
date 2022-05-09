package com.example.english4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
@ResponseBody
@CrossOrigin
//@CrossOrigin设置，跨域问题，让其他ip可以获取参数
public class a {
    @Autowired
    private EnglishMapper englishMapper;
    //查询单词表里的表数据
    @RequestMapping("/a2")
    public String save(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("username");
        System.out.println(a);
        List<english> list=englishMapper.findAll(a);
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }
    //查询收藏表里的表数据
    @RequestMapping("/aa2")
    public String saveaa2(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("username");
        System.out.println(a);
        List<english> list=englishMapper.findAllaa2(a);
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }

//查询单词表
    @RequestMapping("/a")
    public String save2() throws JsonProcessingException {
        List<String> list=englishMapper.findAll2();
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }
    //查询收藏表
    @RequestMapping("/aa")
    public String save2c() throws JsonProcessingException {
        List<String> list=englishMapper.findAll2c();
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }
//词库录入 添加单词
    @RequestMapping("/b")
    public String save3(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("username");
        System.out.println(a);
        String [] aa=a.split(",");
        englishMapper.se(aa[0],aa[1],aa[2]);
        return "单词---"+aa[1]+"---翻译---"+aa[2]+"---添加成功！在"+aa[0];
    }
//出随机单词
    @RequestMapping("/main")
    public String save4(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("username");
        Integer all = englishMapper.findAll3(a);
        System.out.println( englishMapper.findAll3(a));
        int b=new Random().nextInt(all)+1;//随机单词的id
        List<english> list = englishMapper.findAll4(b,a);
        System.out.println(list);
        ObjectMapper mapper=  new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        return json;
    }
//添加到收藏表
    @RequestMapping("/cbiao")
    public String cbiao(HttpServletRequest req) throws JsonProcessingException {
        String a= req.getParameter("biao");
        String b= req.getParameter("ci");
        String c= req.getParameter("fan");
        System.out.println(a+b+c);
         englishMapper.insertc(a,b,c);
        return b+"添加成功";
    }
}
