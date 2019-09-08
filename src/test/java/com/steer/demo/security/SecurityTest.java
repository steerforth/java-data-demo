package com.steer.demo.security;

import com.alibaba.fastjson.JSONObject;
import com.steer.demo.DemoApplicationTests;
import com.steer.demo.common.property.ApplicationProperty;
import com.steer.demo.common.utils.AESUtil;
import com.steer.demo.common.utils.Sha1Util;
import com.steer.demo.dto.Session;
import com.steer.demo.wechat.dto.UserInfoDto;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecurityTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(SecurityTest.class);

    private String sessionKey = "18idQ4oZYEEWV3gJacDNdA==";

    private String appid = "wx06b8d6cf5d6039ad";

    @Autowired
    private ApplicationProperty property;

    @Test
    public void testAES() throws Exception {
        //openid:oA7cI0aHhaVe9LVdFSOXDWlZtJIw
        //session_key:18idQ4oZYEEWV3gJacDNdA==
        //iv:MiVGR8kNG7bxGeXslsq8tw==
        //encrypedData:rsS1xMyf/Duw8jtJ+UmudSunrxCOl+WYYBhZ+EWdQETAE7otzTrQv+gH+V9hSXGWjypoo3Iix0lYbHLe+/qhiDLVRylztpkFKUDHBTkOdFj55Rod4JRXYvLYlCHaB0olZ0S4zKZicjgoSzNTuNVUUbZYSrcP75nX9LwW+itMcku9wS9Ju4d4r8+3GjRriSJQchiQ5b7Pnv1qCXMrqDVQEserblWfuhiYFphiJJP3w9Bu2Op4uKMbiYEYIl788yzW1jpo9dFOf5mI8AfdF1h6yUHvKTs6k+QKHNeoKUboLymdN/ieE0u1jxxlJ1VwjmEoZedUg7FARESWXOaIIxmF/JnkkfMfJmDN0BZvhrbzk4UO7V5yO7Aw9r5NYayrBQOHAyIPDn6N1cu89gYckXF1MOFVJEakF5/EU+GK9diaQeYJ7h7uLrmkvbI6FhNe0F0DbgtLeMT2PRYCqiEKU6KMy4gOS97BJYgtM4/WgCgyIx8=
        //signature:5ddc2c2f12ac56f40c9a51141d808b320a5acac1
        //encrypedData
        String encrypedBase64Str = "rsS1xMyf/Duw8jtJ+UmudSunrxCOl+WYYBhZ+EWdQETAE7otzTrQv+gH+V9hSXGWjypoo3Iix0lYbHLe+/qhiDLVRylztpkFKUDHBTkOdFj55Rod4JRXYvLYlCHaB0olZ0S4zKZicjgoSzNTuNVUUbZYSrcP75nX9LwW+itMcku9wS9Ju4d4r8+3GjRriSJQchiQ5b7Pnv1qCXMrqDVQEserblWfuhiYFphiJJP3w9Bu2Op4uKMbiYEYIl788yzW1jpo9dFOf5mI8AfdF1h6yUHvKTs6k+QKHNeoKUboLymdN/ieE0u1jxxlJ1VwjmEoZedUg7FARESWXOaIIxmF/JnkkfMfJmDN0BZvhrbzk4UO7V5yO7Aw9r5NYayrBQOHAyIPDn6N1cu89gYckXF1MOFVJEakF5/EU+GK9diaQeYJ7h7uLrmkvbI6FhNe0F0DbgtLeMT2PRYCqiEKU6KMy4gOS97BJYgtM4/WgCgyIx8=";
        String ivBase64Str = "MiVGR8kNG7bxGeXslsq8tw==";
        byte[] key = Base64.getDecoder().decode(sessionKey);
        byte[] iv = Base64.getDecoder().decode(ivBase64Str);
        byte[] decryptedData = AESUtil.base64DecryptCBC(encrypedBase64Str, key, iv);
        UserInfoDto userInfoDto = JSONObject.parseObject(decryptedData, UserInfoDto.class);
        LOGGER.info(userInfoDto.toString());
        Assert.assertEquals(appid,userInfoDto.getWatermark().getAppid());
    }

    @Test
    public void testSha1() throws NoSuchAlgorithmException {
        String rawData = "{\"nickName\":\"steer\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Hangzhou\",\"province\":\"Zhejiang\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqmxLANU2J4hzibNO0p2OFsd8wMyHqHNuAyY0BMb4qUiaO5RcyEXRuzuqTBQMtXjicicvdzCNMUia9HnBA/132\"}";
        String signature = "5ddc2c2f12ac56f40c9a51141d808b320a5acac1";
        String sha1Data = Sha1Util.encrypt(rawData+sessionKey);
        Assert.assertEquals(signature,sha1Data);
    }

    @Test
    public void testParseSession() throws Exception {
       byte[] b =  AESUtil.base64Decrypt("kmOJ1083lpVzhJxBYsgOQA==",property.getAesKey());
       new String(b);
       Session session = JSONObject.parseObject(b,Session.class,null);
       LOGGER.info("{}",session.getUserId());
    }


}