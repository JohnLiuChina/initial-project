package com.springcloud.stock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StockMapper {

    @Update("update field set web_conf = 'after updated' where field_key = 'aa'")
    void update();

}
