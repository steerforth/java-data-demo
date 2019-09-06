package com.steer.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.steer.demo.model.Good;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 15:39
 */
public interface GoodService extends IService<Good> {
    /**
     * 促销商品
     * @return
     */
    List<Good> selectBenefits();

    /**
     * 新品
     * @return
     */
    List<Good> selectFirsts();
    /**
     * 热门商品
     * @return
     */
    List<Good> selectHots();
    /**
     * 精品商品
     * @return
     */
    List<Good> selectBasts();
}
