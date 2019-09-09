package com.steer.demo.service.impl;

import com.steer.demo.model.GoodDetail;
import com.steer.demo.dao.GoodDetailMapper;
import com.steer.demo.service.GoodDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Steerforth
 * @since 2019-09-09
 */
@Service
public class GoodDetailServiceImpl extends ServiceImpl<GoodDetailMapper, GoodDetail> implements GoodDetailService {
    @Autowired
    private GoodDetailMapper mapper;

    @Override
    public GoodDetail selectByGoodId(long goodId) {
        return mapper.selectByGoodId(goodId);
    }
}
