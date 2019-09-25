package com.steer.demo.wechat.dto;

import com.steer.demo.common.xml.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description: 统一下单Api参数实体
 * @Date: 2019-09-25 12:21
 */
@XStreamAlias("xml")
public class OrderParam implements Serializable {
    /**
     * 小程序ID
     */
    private String appid;
    /**
     * 商品描述
     */
    private String body;
    /**
     * 商品详情（非必填）
     */
    @XStreamCDATA
    private String detail;
    /**
     * 商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 随机字符串，32位以内
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 支付结果通知的回调地址
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;
    /**
     * 用户标识
     * trade_type=JSAPI，此参数必传
     */
    private String openid;
    /**
     * 商户订单号,32个字符内
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 签名
     */
    private String sign;
    /**
     * 签名类型（非必填），默认为MD5，支持HMAC-SHA256和MD5
     */
    @XStreamAlias("sign_type")
    private String signType;

    /**
     * 调用微信支付API的机器IP
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;
    /**
     * 订单总金额，单位为分
     */
    @XStreamAlias("total_fee")
    private String totalFee;
    /**
     * 交易类型,默认JSAPI
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
