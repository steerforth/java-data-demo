package com.steer.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.steer.demo.model.Menu;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 14:29
 */
public interface MenuService extends IService<Menu> {
    List<Menu> selectAll();
}
