package com.steer.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steer.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT u.id,u.name FROM sys_user u WHERE u.name LIKE #{name}")
    User test(@Param("name") String name);

    @Select("SELECT u.id FROM sys_user u WHERE u.openid = #{openid} AND status != 9")
    User selectByOpenid(@Param("openid") String openid);
}
