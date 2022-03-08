package com.example.springboot002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name01}")
    private String name;
    @Value("${address[0]}")//数组的方式
    private String add1;

    @Autowired
    private Environment a1;
    @Autowired
    private person a2;


    @RequestMapping("/hello")
    public String hello() {
        return "hello Spring boot !";
    }

    @RequestMapping("/a")
    public String a() {
        return name + "...." + add1+a1.getProperty("name02")+a1.getProperty("address[1]");
    }
    @RequestMapping("/b")
    public String b() {
        System.out.println(a2);
        return a2.getName();
    }
}
