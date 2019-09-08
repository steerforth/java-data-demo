package com.steer.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.steer.demo.dao.GoodMapper;
import com.steer.demo.model.Good;
import com.steer.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 15:40
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<Good> selectBenefits() {
        EntityWrapper wrapper = new EntityWrapper<Good>();
        wrapper.eq("benefit",1);
//        wrapper.eq("status",0);
        return goodMapper.selectList(wrapper);
    }

    @Override
    public List<Good> selectFirsts() {
        EntityWrapper wrapper = new EntityWrapper<Good>();
        wrapper.eq("first",1);
//        wrapper.eq("status",0);
        return goodMapper.selectList(wrapper);
    }

    @Override
    public List<Good> selectHots() {
        EntityWrapper wrapper = new EntityWrapper<Good>();
        wrapper.eq("hot",1);
//        wrapper.eq("status",0);
        return goodMapper.selectList(wrapper);
    }

    @Override
    public List<Good> selectBasts() {
        EntityWrapper wrapper = new EntityWrapper<Good>();
        wrapper.eq("bast",1);
//        wrapper.eq("status",0);
        return goodMapper.selectList(wrapper);
    }
}
