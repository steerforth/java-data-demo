package com.steer.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.steer.demo.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 购物车
 */
@TableName("app_cart")
@Entity(name = "app_cart")
public class Cart extends BaseEntity<Cart> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;
    @Column(name = "user_id")
    @TableField(value = "user_id")
    private long userId;
    /**
     * Good id
     */
    @Column(name = "product_id")
    @TableField(value = "product_id")
    @JSONField(name = "product_id")
    private long productId;
    /**
     * 购物车 商品数量
     */
    @Column(name = "cart_num")
    @TableField(value = "cart_num")
    @JSONField(name = "cart_num")
    private int cartNum;
    /**
     *
     */
    @Column(name = "true_price")
    @TableField(value = "true_price")
    private float truePrice;

    /**
     *  ========冗余========
     */
    @Transient
    private Good productInfo;

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCartNum() {
        return cartNum;
    }

    public void setCartNum(int cartNum) {
        this.cartNum = cartNum;
    }

    public Good getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Good productInfo) {
        this.productInfo = productInfo;
    }

    public float getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(float truePrice) {
        this.truePrice = truePrice;
    }
}
