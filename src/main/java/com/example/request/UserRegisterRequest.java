package com.example.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用于用户注册的请求体
 *
 * @author SurKaa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3913974494565275606L;

    private String username;
    private String password;
    private String checkPassword;

}
