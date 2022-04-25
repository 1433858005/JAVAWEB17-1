package com.example.english3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@ResponseBody
public class a {
    @Autowired
    private EnglishMapper englishMapper;

    @RequestMapping("/s")
    public String save(){
        List<english> list=englishMapper.findAll();
        System.out.println(list);
        return "list666";
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
        return "json";
    }
}
