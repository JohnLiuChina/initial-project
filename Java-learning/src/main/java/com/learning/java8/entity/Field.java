package com.learning.java8.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "field")
public class Field {

    @TableField(value = "")
    private Integer id;

    @TableField(value = "field_key")
    private String fieldKey;

    @TableField(value = "web_conf")
    private String webConf;

    @TableField(exist = false)
    private String fieldValue;

}
