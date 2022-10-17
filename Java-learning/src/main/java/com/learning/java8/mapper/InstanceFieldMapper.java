package com.learning.java8.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learning.java8.entity.InstanceFieldRef;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface InstanceFieldMapper extends BaseMapper<InstanceFieldRef> {
}
