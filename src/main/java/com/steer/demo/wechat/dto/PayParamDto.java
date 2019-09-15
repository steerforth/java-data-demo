package com.steer.demo.wechat.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class PayParamDto {
    private long timestamp;
    private String nonceStr;
    @JSONField(name = "package")
    @XStreamAlias("package")
    private String prepayId;
    private String signType;
    private String paySign;
    private String appId;

    public String buildLinkStr(){
        return new StringBuilder().append("appId=").append(this.appId).
                append("&nonceStr=").append(this.nonceStr).
                append("&package=prepay_id=").append(this.prepayId).
                append("&signType=").append(this.signType).
                append("&timeStamp=").append(this.timestamp).toString();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
