package com.steer.demo.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.steer.demo.common.model.BaseEntity;
import com.steer.demo.dto.UserInfo;
import com.steer.demo.wechat.dto.UserInfoDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:14
 */
@TableName("sys_user")
@Entity(name = "sys_user")
public class User extends BaseEntity<User> {
    /**
     * 状态：0为正常，9为删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private short status;

    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;
    /**
     * 加盐
     */
    @JSONField(serialize = false)
    private String salt;
    /**
     * 姓名
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 手机
     */
    private String mobile;
    /**
     * ============微信信息=========
     */
    private String openid;

    private String unionid;
    /**
     * 推广人二维码id
     */
    @Column(name = "spread_code")
    @TableField(value = "spread_code")
    private Long spreadCode;
    /**
     * 推广人id
     */
    @Column(name = "spread_spid")
    @TableField(value = "spread_spid")
    private Long spreadSpid;

    @Column(name = "nick_name")
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 1为男性，0位女性
     */
    private short gender;
    /**
     * 使用微信采用的语言，简体中文，繁体或英文
     */
    private String language;

    private String city;

    private String province;

    private String country;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getSpreadCode() {
        return spreadCode;
    }

    public void setSpreadCode(Long spreadCode) {
        this.spreadCode = spreadCode;
    }

    public Long getSpreadSpid() {
        return spreadSpid;
    }

    public void setSpreadSpid(Long spreadSpid) {
        this.spreadSpid = spreadSpid;
    }

    @Override
    protected Serializable pkVal() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "User{" +
                "status=" + status +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", mobile='" + mobile + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", spreadCode=" + spreadCode +
                ", spreadSpid=" + spreadSpid +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public User buildUserByWechat(UserInfo userInfo) {
        User user = new User();
        user.setSpreadCode(userInfo.getSpreadCode());
        user.setSpreadSpid(userInfo.getSpreadSpid());

        UserInfoDto userInfoDto = JSONObject.parseObject(userInfo.getRawData(),UserInfoDto.class);
        user.setAvatarUrl(userInfoDto.getAvatarUrl());
        user.setNickName(userInfoDto.getNickName());
        user.setCountry(userInfoDto.getCountry());
        user.setProvince(userInfoDto.getProvince());
        user.setCity(userInfoDto.getCity());
        user.setGender(userInfoDto.getGender());
        return user;
    }
}
