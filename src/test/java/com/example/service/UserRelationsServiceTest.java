package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserRelationsService 测试
 */
@SpringBootTest
class UserRelationsServiceTest {

    @Autowired
    private UserRelationsService userRelationsService;

    @Test
    void count() {
        System.out.println("userRelationsService.count() = " + userRelationsService.count());
    }
}