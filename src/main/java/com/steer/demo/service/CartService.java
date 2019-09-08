package com.steer.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.steer.demo.model.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {
    List<Cart> selectValidListByUser(long userId);
    List<Cart> selectInvalidListByUser(long userId);

    int selectCartCount(long userId);
}
