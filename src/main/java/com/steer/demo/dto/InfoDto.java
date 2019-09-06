package com.steer.demo.dto;

import com.steer.demo.model.Good;

import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 16:02
 */
public class InfoDto {
    /**
     * 精品商品
     */
    private String bastInfo;
    private List<BastBannerDto> bastBanner;
    private List<Good> bastList;
    /**
     * 快读选择区域
     */
    private String fastInfo;
    private List<FastDto> fastList;
    /**
     * 新品商品
     */
    private String firstInfo;
    private List<Good> firstList;

    private String salesInfo;

    /**
     * 横幅
     */
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBastInfo() {
        return bastInfo;
    }

    public void setBastInfo(String bastInfo) {
        this.bastInfo = bastInfo;
    }

    public List<BastBannerDto> getBastBanner() {
        return bastBanner;
    }

    public void setBastBanner(List<BastBannerDto> bastBanner) {
        this.bastBanner = bastBanner;
    }

    public List<Good> getBastList() {
        return bastList;
    }

    public void setBastList(List<Good> bastList) {
        this.bastList = bastList;
    }

    public String getFastInfo() {
        return fastInfo;
    }

    public void setFastInfo(String fastInfo) {
        this.fastInfo = fastInfo;
    }

    public List<FastDto> getFastList() {
        return fastList;
    }

    public void setFastList(List<FastDto> fastList) {
        this.fastList = fastList;
    }

    public String getFirstInfo() {
        return firstInfo;
    }

    public void setFirstInfo(String firstInfo) {
        this.firstInfo = firstInfo;
    }

    public List<Good> getFirstList() {
        return firstList;
    }

    public void setFirstList(List<Good> firstList) {
        this.firstList = firstList;
    }

    public String getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(String salesInfo) {
        this.salesInfo = salesInfo;
    }
}
