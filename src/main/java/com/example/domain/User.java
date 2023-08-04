package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
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
    private Integer isDelete;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}