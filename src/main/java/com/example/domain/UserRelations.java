package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author R2ABC, SurKaa
 * @TableName user_relations
 */
@TableName(value = "user_relations")
@Data
public class UserRelations implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -4573540993052827339L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long friendId;

    private Integer status;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}