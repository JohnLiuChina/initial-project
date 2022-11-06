package com.learning.java8.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "instance_field")
public class InstanceFieldRef {

    @TableField(value = "id")
    private Integer id;

    @TableField(value = "instance_id")
    private Integer instanceId;

    @TableField(value = "field_id")
    private Integer fieldId;

    @TableField(value = "field_value")
    private String fieldValue;

}
