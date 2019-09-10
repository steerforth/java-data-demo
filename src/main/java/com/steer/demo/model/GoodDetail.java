package com.steer.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.steer.demo.common.model.BaseEntity;
import com.steer.demo.dto.GoodDto;
import com.steer.demo.dto.ProductAttrDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@TableName("app_good_detail")
@Entity(name = "app_good_detail")
public class GoodDetail extends BaseEntity<GoodDetail> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;

    @Column(name = "good_id")
    @TableField(value = "good_id")
    private String goodId;

    @Column(name = "reply_count")
    @TableField(value = "reply_count")
    private int replyCount;
    /**
     * 好评率 0-100
     */
    @Column(name = "reply_chance")
    @TableField(value = "reply_chance")
    private short replyChance;
    /**
     * 会员分享该商品反的价格
     */
    @Column(name = "price_name")
    @TableField(value = "price_name")
    private String priceName;

    /**
     * ========冗余字段======
     */
    @Transient
    @TableField(exist = false)
    private Good storeInfo;
    @Transient
    @TableField(exist = false)
    private List<Reply> reply;
    @Transient
    @TableField(exist = false)
    private List<ProductAttrDto> productAttr;
    @Transient
    @TableField(exist = false)
    private Map<String, GoodDto> productValue;

    public List<ProductAttrDto> getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(List<ProductAttrDto> productAttr) {
        this.productAttr = productAttr;
    }

    public Map<String, GoodDto> getProductValue() {
        return productValue;
    }

    public void setProductValue(Map<String, GoodDto> productValue) {
        this.productValue = productValue;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public short getReplyChance() {
        return replyChance;
    }

    public void setReplyChance(short replyChance) {
        this.replyChance = replyChance;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Good getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(Good storeInfo) {
        this.storeInfo = storeInfo;
    }

    public List<Reply> getReply() {
        return reply;
    }

    public void setReply(List<Reply> reply) {
        this.reply = reply;
    }

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }
}
