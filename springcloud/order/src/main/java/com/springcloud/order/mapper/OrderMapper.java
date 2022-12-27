package com.springcloud.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("insert into field values(null, 'aa', 'abc', 'testing')")
    void insert();

}
