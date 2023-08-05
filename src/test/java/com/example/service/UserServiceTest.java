package com.example.service;

import com.example.request.UserLoginRequest;
import com.example.request.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserService 测试
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void register() {
        System.out.println("userService.register(new UserRegisterRequest(" +
                "\"username\", \"password\", \"password\")) = "
                + userService.register(new UserRegisterRequest(
                "username",
                "password",
                "password"))
        );
    }

    @Test
    void login() {
        System.out.println("userService.login(new UserLoginRequest(" +
                "\"username\", \"password\")) = "
                + userService.login(new UserLoginRequest(
                "username",
                "password"))
        );
    }
}