package com.example.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登陆操作的请求体
 *
 * @author SurKaa
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 7416445495354843626L;

    private String username;
    private String password;

}
