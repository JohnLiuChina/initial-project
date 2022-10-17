package com.learning.java8.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learning.java8.entity.Field;
import com.learning.java8.entity.Instance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FieldMapper extends BaseMapper<Field> {

    IPage<Instance> pageList(IPage<Instance> page, @Param("list") String list);
    List<Field> getFields(@Param("id") Integer instanceId, @Param("list") String keyList);

}
