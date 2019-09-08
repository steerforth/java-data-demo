package com.steer.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steer.demo.model.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper extends BaseMapper<Cart> {

    List<Cart> selectValidListByUser(@Param("userId") long userId);

    List<Cart> selectInvalidListByUser(@Param("userId")long userId);
}
