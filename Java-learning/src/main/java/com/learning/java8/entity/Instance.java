package com.learning.java8.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.File;
import java.util.Date;
import java.util.List;

@Data
@TableName(value = "instance")
public class Instance {

    @TableField(value = "id")
    private Integer id;

    @TableField(value = "instance_name")
    private String instanceName;

    @TableField(value = "prompt_cn")
    private String promptCn;

    @TableField(value = "created_time")
    private Date createdTime;

    @TableField(exist = false)
    private List<Field> fields;

}
