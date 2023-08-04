package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName message
 */
@TableName(value ="message")
@Data
public class Message implements Serializable {
    private Long id;

    private Long senderId;

    private Long receiverId;

    private Long type;

    private String content;

    private Integer isRead;

    private Date createTime;

    private Integer isDelete;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}