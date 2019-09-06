package com.steer.demo.dto;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:首页 滚动图
 * @Date: 2019-09-06 14:23
 */
public class Banner {
    String url;
    String pic;

    public Banner(String url, String pic) {
        this.url = url;
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
