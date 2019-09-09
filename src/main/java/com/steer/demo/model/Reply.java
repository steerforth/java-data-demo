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
import java.util.Date;
import java.util.List;

/**
 * 评价
 */
@TableName("app_reply")
@Entity(name = "app_reply")
public class Reply extends BaseEntity<Reply> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;
    /**
     * 评价用户头像
     */
    private String avatar;

    private String nickname;
    /**
     * 几星级用户
     */
    private short star;
    @Column(name = "add_time")
    @TableField(value = "add_time")
    @JSONField(name="add_time",format="yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    /**
     *
     */
    private String suk;
    /**
     * 评论
     */
    private String comment;
    /**
     * 商家回复
     */
    @Column(name = "merchant_reply_content")
    @TableField(value = "merchant_reply_content")
    @JSONField(name="merchant_reply_content")
    private String merchantReplyContent;
    /**
     * 商品详情
     */
    @Column(name = "good_detail_id")
    @TableField(value = "good_detail_id")
    private String goodDetailId;

    /**
     *
     * @return
     */
    @Transient
    private List<String> pics;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public short getStar() {
        return star;
    }

    public void setStar(short star) {
        this.star = star;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSuk() {
        return suk;
    }

    public void setSuk(String suk) {
        this.suk = suk;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getMerchantReplyContent() {
        return merchantReplyContent;
    }

    public void setMerchantReplyContent(String merchantReplyContent) {
        this.merchantReplyContent = merchantReplyContent;
    }

    public String getGoodDetailId() {
        return goodDetailId;
    }

    public void setGoodDetailId(String goodDetailId) {
        this.goodDetailId = goodDetailId;
    }
}
