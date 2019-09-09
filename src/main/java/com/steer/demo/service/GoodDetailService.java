package com.steer.demo.service;

import com.steer.demo.model.GoodDetail;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Steerforth
 * @since 2019-09-09
 */
public interface GoodDetailService extends IService<GoodDetail> {
    GoodDetail selectByGoodId(long goodId);
}
