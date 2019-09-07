package com.steer.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class TokenDto {
    private String token;
    private UserInfo userInfo;
    @JSONField(name = "expires_time")
    private long expiresTime;
    @JSONField(name = "cache_key")
    private String cacheKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
}
