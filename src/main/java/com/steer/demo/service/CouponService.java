package com.steer.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.steer.demo.model.Coupon;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 16:57
 */
public interface CouponService extends IService<Coupon> {

    List<Coupon> selectByUserId();

    List<Coupon> selectAll();

    Page<Coupon> selectPageByUserId(int start, int limit, long userId);
}
