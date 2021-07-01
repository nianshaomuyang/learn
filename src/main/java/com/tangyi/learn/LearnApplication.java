package com.tangyi.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//扫描dao层
@MapperScan("com.tangyi.learn.dao")

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
