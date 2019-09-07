package com.steer.demo.wechat.dto;

/**
 * 敏感信息
 */
public class WatermarkDto {
    /**
     * 开发者appid
     */
    private String appid;
    /**
     * 敏感数据获取的时间戳
     */
    private long timestamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WatermarkDto{" +
                "appid='" + appid + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
