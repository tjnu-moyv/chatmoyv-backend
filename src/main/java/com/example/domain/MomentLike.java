package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author R2ABC, SurKaa
 * @TableName moment_like
 */
@TableName(value = "moment_like")
@Data
public class MomentLike implements Serializable {

    @TableField
    private static final long serialVersionUID = -6932639491473739187L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long momentId;

    private Long userId;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}