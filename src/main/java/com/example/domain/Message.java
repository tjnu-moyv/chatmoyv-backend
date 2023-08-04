package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author R2ABC, SurKaa
 * @TableName message
 */
@TableName(value = "message")
@Data
public class Message implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1297004463834663706L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long senderId;

    private Long receiverId;

    private Long type;

    private String content;

    private Integer isRead;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}