package com.steer.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.steer.demo.dao.CouponMapper;
import com.steer.demo.model.Coupon;
import com.steer.demo.model.Good;
import com.steer.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 16:57
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public List<Coupon> selectByUserId() {
        //TO DO
        return null;
    }

    @Override
    public List<Coupon> selectAll() {
        EntityWrapper wrapper = new EntityWrapper<Good>();
//        wrapper.eq("status",0);
        return couponMapper.selectList(wrapper);
    }

    @Override
    public Page<Coupon> selectPageByUserId(int start, int limit, long userId) {
        Page<Coupon> page = new Page<>(start,limit);
        EntityWrapper wrapper = new EntityWrapper<Coupon>();
        wrapper.eq("user_id",userId);
        return this.selectPage(page,wrapper);
    }
}
