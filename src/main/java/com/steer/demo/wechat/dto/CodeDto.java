package com.steer.demo.wechat.dto;

/**
 * wx.login获取
 */
public class CodeDto {
    //前端调用wx.login获取的登录凭证（code），有效期5分钟,用于获取session_key的参数
    //"071qEDBy198Ex90b78Ay199tBy1qEDBF"
    private String code;
    //login:ok
    private String errMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
