package com.ljq.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : lijq
 * @date : 2020/3/30 9:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    /**
     * 乐观锁Version注解
     */
    @Version
    private Integer version = 1;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted = 0;

    /**
     * 字段添加填充内容
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
