package com.steer.demo.dto;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 16:04
 */
public class BastBannerDto {
    private String link;
    private String img;

    public BastBannerDto(String img) {
        this.img = img;
    }

    public BastBannerDto(String link, String img) {
        this.link = link;
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
