package com.steer.demo.dto;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 滚动文字信息
 * @Date: 2019-09-06 15:23
 */
public class Roll {
    /**
     * 为偶数表示最新消息，在前段页面有“最新”前缀标识
     */
    private int id;
    private String info;
    private String url;

    public Roll(int id, String info, String url) {
        this.id = id;
        this.info = info;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
