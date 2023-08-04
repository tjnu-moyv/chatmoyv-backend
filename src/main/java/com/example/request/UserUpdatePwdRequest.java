package com.example.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户修改密码请求体
 *
 * @author SurKaa
 */
@Data
public class UserUpdatePwdRequest implements Serializable {

    private static final long serialVersionUID = 6752728535515236319L;

    private String oldPassword;
    private String newPassword;

}
