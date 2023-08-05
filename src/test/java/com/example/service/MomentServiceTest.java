package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MomentService 测试
 */
@SpringBootTest
class MomentServiceTest {

    @Autowired
    private MomentService momentService;

    @Test
    void count() {
        System.out.println("momentService.count() = " + momentService.count());
    }
}