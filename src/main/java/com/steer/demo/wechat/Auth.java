package com.steer.demo.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 作废
 */
public class Auth {
    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 会话密钥
     */
    @JSONField(name = "session_key")
    private String sessionKey;
    /**
     * 用户在开放平台的唯一标识符
     */
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
