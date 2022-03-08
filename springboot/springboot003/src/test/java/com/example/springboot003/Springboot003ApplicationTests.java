package com.example.springboot003;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes =Springboot003Application.class)
public class Springboot003ApplicationTests {
     @Autowired
     private UserService userService;
    @Test
    void contextLoads() {
         userService.add();
    }
}
