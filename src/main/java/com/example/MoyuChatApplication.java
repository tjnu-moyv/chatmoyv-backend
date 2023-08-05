package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author SurKaa
 */
@MapperScan("com.example.mapper")
@SpringBootApplication
public class MoyuChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoyuChatApplication.class, args);
    }

}
