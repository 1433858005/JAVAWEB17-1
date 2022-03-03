package com.example.spring001.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JDBCConflg {
    @Bean("dataSource")
    public DruidDataSource getDataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ssmbuild");
        ds.setUsername("root");
        ds.setPassword("15149622693");
        return ds;
    }
}
