package com.steer.demo.dto;

import com.steer.demo.model.Coupon;
import com.steer.demo.model.Good;
import com.steer.demo.model.Menu;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 首页信息内容
 * @Date: 2019-09-06 14:21
 */
public class IndexInfo {
    /**
     * 首页左上角的Logo
     */
    private String logoUrl;
    /**
     * 首页滚动图
     */
    private List<Banner> banner;
    /**
     * 首页菜单
     */
    private List<Menu> menus;
    /**
     * 首页滚动文字消息
     */
    private List<Roll> roll;
    /**
     * 首页活动专区
     */
    private List<Activity> activity;
    /***
     * 促销商品
     */
    private List<Good> benefit;
    /**
     * 热门商品
     */
    private List<Good> likeInfo;
    /**
     * 信息
     */
    private InfoDto info;

    /**
     * 横幅,只用到img字段
     */
    private List<BastBannerDto> lovelyBanner;

    /**
     * 首页弹出的优惠券
     */
    private List<Coupon> couponList;

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<BastBannerDto> getLovelyBanner() {
        return lovelyBanner;
    }

    public void setLovelyBanner(List<BastBannerDto> lovelyBanner) {
        this.lovelyBanner = lovelyBanner;
    }

    public List<Good> getLikeInfo() {
        return likeInfo;
    }

    public void setLikeInfo(List<Good> likeInfo) {
        this.likeInfo = likeInfo;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public List<Good> getBenefit() {
        return benefit;
    }

    public void setBenefit(List<Good> benefit) {
        this.benefit = benefit;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public List<Roll> getRoll() {
        return roll;
    }

    public void setRoll(List<Roll> roll) {
        this.roll = roll;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
