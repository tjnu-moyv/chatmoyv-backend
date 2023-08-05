package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MomentCommentService 测试
 */
@SpringBootTest
class MomentCommentServiceTest {

    @Autowired
    private MomentCommentService momentCommentService;

    @Test
    void count() {
        System.out.println("momentCommentService.count() = " + momentCommentService.count());
    }
}