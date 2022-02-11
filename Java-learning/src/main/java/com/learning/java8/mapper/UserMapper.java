package com.learning.java8.mapper;

import com.learning.java8.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * Jpa中已经包含findAll接口
 */
@Mapper
//public interface UserMapper extends JpaRepository<User, Long> {
public interface UserMapper {
    @Select("select * from user where username like '%${username}%'")
    List<User> findUserByName(String username);
}
