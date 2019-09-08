package com.steer.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.steer.demo.dao.CartMapper;
import com.steer.demo.model.Cart;
import com.steer.demo.model.Good;
import com.steer.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper,Cart> implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> selectValidListByUser(long userId) {
        return cartMapper.selectValidListByUser(userId);
    }

    @Override
    public List<Cart> selectInvalidListByUser(long userId) {
        return cartMapper.selectInvalidListByUser(userId);
    }

    @Override
    public int selectCartCount(long userId) {
        EntityWrapper wrapper = new EntityWrapper<Cart>();
        wrapper.eq("user_id",userId);
        return cartMapper.selectCount(wrapper);
    }
}
