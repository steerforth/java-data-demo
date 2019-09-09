package com.steer.demo.dao;

import com.steer.demo.model.GoodDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Steerforth
 * @since 2019-09-09
 */
public interface GoodDetailMapper extends BaseMapper<GoodDetail> {

    GoodDetail selectByGoodId(@Param("goodId") long goodId);
}
