package com.example.english4.wenjian;
import com.example.english4.EnglishMapper;
import com.example.english4.english;
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
public class coll {
//    @Autowired
//    private EnglishMapper englishMapper;
//    //查询单词表里的表数据
//    @RequestMapping("/a2")
//    public String save(HttpServletRequest req) throws JsonProcessingException {
//        String a= req.getParameter("username");
//        System.out.println(a);
//        List<english> list=englishMapper.findAll(a);
//        System.out.println(list);
//        ObjectMapper mapper=  new ObjectMapper();
//        String json =mapper.writeValueAsString(list);
//        return json;
//    }
}
