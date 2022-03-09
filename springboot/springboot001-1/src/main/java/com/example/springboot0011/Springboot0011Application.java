package com.example.springboot0011;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class Springboot0011Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0011Application.class, args);
    }

}
