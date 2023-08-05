package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * messageService 测试
 */
@SpringBootTest
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    void count() {
        System.out.println("messageService.count() = " + messageService.count());
    }
}