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

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 商品
 * @Date: 2019-09-06 13:12
 */
@TableName("app_good")
@Entity(name = "app_good")
public class Good extends BaseEntity<Good> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;

    @Column(name = "vip_price")
    @TableField(value = "vip_price")
    @JSONField(name="vip_price")
    private float vipPrice;
    /**
     * 现在价格
     */
    private float price;
    /**
     * 原价
     */
    @TableField(value = "ot_price")
    @Column(name = "ot_price")
    @JSONField(name="ot_price")
    private float otPrice;
    /**
     * 商品计量单位
     */
    @Column(name = "unit_name")
    @TableField(value = "unit_name")
    @JSONField(name="unit_name")
    private String unitName;
    /**
     * 卖出数量
     */
    private long sales;
    /**
     * 剩余数量
     */
    private long stock;

    @Column(name = "store_name")
    @TableField(value = "store_name")
    @JSONField(name="store_name")
    private String storeName;
    /**
     * 商品对应图片
     */
    private String image;
    /**
     * 是否为促销商品
     */
    private boolean benefit;
    /**
     * 是否为新品商品
     */
    private boolean first;
    /**
     * 是否为热门商品
     */
    private boolean hot;
    /**
     * 是否为精品商品
     */
    private boolean bast;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isBast() {
        return bast;
    }

    public void setBast(boolean bast) {
        this.bast = bast;
    }

    public boolean isBenefit() {
        return benefit;
    }

    public void setBenefit(boolean benefit) {
        this.benefit = benefit;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public float getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(float vipPrice) {
        this.vipPrice = vipPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOtPrice() {
        return otPrice;
    }

    public void setOtPrice(float otPrice) {
        this.otPrice = otPrice;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Good{" +
                "status=" + status +
                ", vipPrice=" + vipPrice +
                ", price=" + price +
                ", otPrice=" + otPrice +
                ", unitName='" + unitName + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", storeName='" + storeName + '\'' +
                ", image='" + image + '\'' +
                ", benefit=" + benefit +
                ", first=" + first +
                ", hot=" + hot +
                ", bast=" + bast +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
