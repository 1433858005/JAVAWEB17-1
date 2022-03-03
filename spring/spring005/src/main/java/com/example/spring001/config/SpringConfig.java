package com.example.spring001.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.spring001")
@Import(JDBCConflg.class)
public class SpringConfig {

}
