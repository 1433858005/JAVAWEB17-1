package com.example.springboot004;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
@SpringBootTest
class Springboot004ApplicationTests {
    @Autowired
    private EnglishMapper englishMapper;
//    private UserMapper userMapper;

    @Test
    void contextLoads() {
      List<english> list=englishMapper.findAll();
//        List<User> list=userMapper.findAll();
        System.out.println(list);
    }
}
