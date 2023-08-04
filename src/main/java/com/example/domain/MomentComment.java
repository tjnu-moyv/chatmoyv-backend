package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName moment_comment
 */
@TableName(value ="moment_comment")
@Data
public class MomentComment implements Serializable {
    private Long id;

    private Long momentId;

    private Long userId;

    private String content;

    private Date createTime;

    private Integer isDelete;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}