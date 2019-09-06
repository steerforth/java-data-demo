package com.steer.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.steer.demo.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 优惠券
 * @Date: 2019-09-06 16:52
 */
@TableName("app_coupon")
@Entity(name = "app_coupon")
public class Coupon extends BaseEntity<Coupon> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer status;
    /**
     *优惠折扣价格
     */
    @Column(name = "coupon_price")
    @TableField(value = "coupon_price")
    @JSONField(name="coupon_price")
    private Float couponPrice;
    /**
     *最少使用多少钱才能使用
     */
    @Column(name = "use_min_price")
    @TableField(value = "use_min_price")
    @JSONField(name="use_min_price")
    private Float useMinPrice;
    /**
     * 券使用开始时间
     */
    @Column(name = "add_time")
    @TableField(value = "add_time")
    @JSONField(name="add_time",format="yyyy.MM.dd HH:mm")
    private Date addTime;
    /**
     * 券使用截止时间
     */
    @Column(name = "end_time")
    @TableField(value = "end_time")
    @JSONField(name="end_time",format="yyyy.MM.dd HH:mm")
    private Date endTime;

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Float getUseMinPrice() {
        return useMinPrice;
    }

    public void setUseMinPrice(Float useMinPrice) {
        this.useMinPrice = useMinPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
