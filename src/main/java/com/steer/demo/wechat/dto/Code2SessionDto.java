package com.steer.demo.wechat.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 */
public class Code2SessionDto {
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
     * 用户在开放平台的唯一标识符,在满足 UnionID 下发条件的情况下会返回
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

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Override
    public String toString() {
        return "Code2SessionDto{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
