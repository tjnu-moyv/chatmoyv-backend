package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName user_relations
 */
@TableName(value ="user_relations")
@Data
public class UserRelations implements Serializable {
    private Long id;

    private Long userId;

    private Long friendId;

    private Integer status;

    private Date createTime;

    private Integer isDelete;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}