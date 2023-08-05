package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * FavoriteService 测试
 */
@SpringBootTest
class FavoriteServiceTest {

    @Autowired
    private FavoriteService favoriteService;

    @Test
    public void serviceTest() {
        System.out.println("favoriteService.count() = " + favoriteService.count());
    }

}