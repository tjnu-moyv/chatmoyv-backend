package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author R2ABC, SurKaa
 * @TableName moment
 */
@TableName(value = "moment")
@Data
public class Moment implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 8075992367955905932L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String content;

    private Integer likeCount;

    private Integer commentCount;

    private String imageList;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}