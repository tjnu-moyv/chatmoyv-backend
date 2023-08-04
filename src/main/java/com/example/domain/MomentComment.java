package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author R2ABC, SurKaa
 * @TableName moment_comment
 */
@TableName(value = "moment_comment")
@Data
public class MomentComment implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 3189612596617924534L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long momentId;

    private Long userId;

    private String content;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}