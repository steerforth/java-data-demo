package com.steer.demo.dto;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 活动专区
 * @Date: 2019-09-06 15:29
 */
public class Activity {
    private String link;
    private String pic;
    private String title;
    private String info;

    public Activity(String link, String pic, String title, String info) {
        this.link = link;
        this.pic = pic;
        this.title = title;
        this.info = info;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
