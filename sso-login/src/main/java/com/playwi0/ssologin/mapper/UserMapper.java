package com.playwi0.ssologin.mapper;

import com.playwi0.ssoapi.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
@Mapper
public interface UserMapper {

    @Select("select * from tb_user where userName = #{username} and password = #{password}")
    @Results({
        @Result(column = "userID", property = "userId"),
        @Result(column = "userName", property = "username"),
        @Result(column = "password", property = "password")
    })
    User selectUserByName(@Param("username") String username, @Param("password") String password);
}
