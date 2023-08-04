package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName moment
 */
@TableName(value ="moment")
@Data
public class Moment implements Serializable {
    private Long id;

    private Long userId;

    private String content;

    private Integer likeCount;

    private Integer commentCount;

    private String imageList;

    private Date createTime;

    private Integer isDelete;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}