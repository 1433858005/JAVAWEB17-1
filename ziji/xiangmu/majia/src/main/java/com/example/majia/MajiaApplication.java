package com.example.majia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.example.MajiaApplication.dao")
public class MajiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MajiaApplication.class, args);
    }

}
