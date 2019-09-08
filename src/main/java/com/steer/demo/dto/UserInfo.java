package com.steer.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * wx.getUserInfo获得
 */
public class UserInfo {
    /**
     * 前端调用wx.login获取的登录凭证（code），有效期5分钟,用于获取session_key的参数
     */
    private String code;
    //"r6Nu78fJNls3bhO0XaZq3EQkGIG8eBm7KiaZMw9Torl4AyIB4b9Qc+456929rgl+TGVoYJfgCJLg7EG2pUN2HOyyX7AoSjXlr33s40u1qrDIzrRI8MQg3oaOYH7X33DP0VmZkjblhebcRexwWrGY2fiWADoTLeij9waKwSVWCy2qtRhZttFj7pa5KaIinOiosFcITndtioEH3HBg/wLRREU8z1qiNJeyW9xrqRlkkH2N3gX5H7LdNRVM32oFahVDfJB6cLmEBwQWeyYO0qje92Cf+WF0AD9hMmp1R47UPwzsqIHbP7vT451uspWNzUegfcH/99YCWeEuqOaZouL/Yix7Zyd7Wuu4PspMOQ+aO7IWCbDV6eI52VSoOy8ExsD6o07/U61esQYeZaNyifGQiovBy2WUaxSzfQvM7cw9pwcptoAdq3J7SiSavePRcRKjgVLzZPEkMbgeCh50dAk1VP3DIWM7XF7xfMpEiDXdpR8="
    /**
     * 包括敏感数据在内的完整用户信息的加密数据
     */
    private String encryptedData;
    //"getUserInfo:ok"
    private String errMsg;
    //"oBYE63KbNffUODcMErJviQ=="
    /**
     * 加密算法的初始向量
     */
    private String iv;
    //"9292a5ed2bb5c548d779793be6d26188dde286c1"
    /**
     * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     */
    private String signature;
    /**
     * 微信个人信息
     * 不包括敏感信息的原始数据字符串，用于计算签名
     */
    private String rawData;
    /**
     * 推广人二维码id
     */
    @JSONField(name = "spread_code")
    private long spreadCode;
    /**
     * 推广人id
     */
    @JSONField(name = "spread_spid")
    private long spreadSpid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public long getSpreadCode() {
        return spreadCode;
    }

    public void setSpreadCode(long spreadCode) {
        this.spreadCode = spreadCode;
    }

    public long getSpreadSpid() {
        return spreadSpid;
    }

    public void setSpreadSpid(long spreadSpid) {
        this.spreadSpid = spreadSpid;
    }
}
