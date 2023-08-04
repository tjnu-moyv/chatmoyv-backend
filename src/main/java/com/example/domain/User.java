package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SurKaa
 * @TableName user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private Integer gender;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private Date birthday;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private String education;

    /**
     *
     */
    private String occupation;

    /**
     *
     */
    private String interests;

    /**
     *
     */
    private String bio;

    /**
     *
     */
    private Date lastLoginTime;

    /**
     *
     */
    private Date passwordChangeTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户状态 0 - 正常
     */
    private Integer userStatus;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 更新时间
     */
    private Date updateTime;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /**
     * 用于脱敏用户信息
     *
     * @param user 用户
     */
    public static User safe(User user) {
        User safe = new User();
        safe.id = user.id;
        safe.username = user.username;
        // password置空
        // safe.password = user.password;
        safe.nickname = user.nickname;
        safe.gender = user.gender;
        safe.email = user.email;
        safe.phoneNumber = user.phoneNumber;
        safe.birthday = user.birthday;
        safe.address = user.address;
        safe.education = user.education;
        safe.occupation = user.occupation;
        safe.interests = user.interests;
        safe.bio = user.bio;
        safe.lastLoginTime = user.lastLoginTime;
        safe.passwordChangeTime = user.passwordChangeTime;
        safe.createTime = user.createTime;
        safe.userStatus = user.userStatus;
        safe.role = user.role;
        safe.isDelete = user.isDelete;
        safe.updateTime = user.updateTime;
        return safe;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}