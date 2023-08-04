package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author R2ABC, SurKaa
 * @TableName favorite
 */
@TableName(value = "favorite")
@Data
public class Favorite implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 5863139197176753126L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String content;

    private Date createTime;

    @TableLogic
    private Integer isDelete;

    private Date updateTime;
}