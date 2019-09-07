package com.steer.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.steer.demo.common.property.ApplicationProperty;
import com.steer.demo.common.utils.AESUtil;
import com.steer.demo.dto.TokenDto;
import com.steer.demo.dto.UserInfo;
import com.steer.demo.model.User;
import com.steer.demo.service.UserService;
import com.steer.demo.service.WechatService;
import com.steer.demo.wechat.dto.Code2SessionDto;
import com.steer.demo.wechat.dto.ErrorDto;
import com.steer.demo.wechat.dto.UserInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class WechatServiceImpl implements WechatService {
    private static final String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={jsCode}&grant_type=authorization_code";
    private static Logger LOGGER = LoggerFactory.getLogger(WechatServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationProperty property;
    @Autowired
    private UserService userService;

    @Override
    public TokenDto authAndCheck(UserInfo userInfo) throws Exception {
        Code2SessionDto sessionDto = this.getWxSession(userInfo);
        if (sessionDto != null){
            if(this.checkAppid(sessionDto,userInfo)){
                return this.getToken(userInfo,sessionDto);
            }
        }
        return null;
    }

    private TokenDto getToken(UserInfo userInfo,Code2SessionDto sessionDto) throws Exception {
        User user = userService.selectByOpenid(sessionDto.getOpenid());
        if (user == null){
            user = user.buildUserByWechat(userInfo);
            userService.insert(user);
        }

        TokenDto dto = new TokenDto();
        //TO DO
        dto.setCacheKey("fwkkkkkk");
        dto.setExpiresTime(System.currentTimeMillis()+3600*1000*2);
        dto.setUserInfo(userInfo);
        dto.setToken(AESUtil.base64Encrypt(String.valueOf(user.getId()).getBytes(),property.getAesKey()));
        return dto;
    }

    private boolean checkAppid(Code2SessionDto sessionDto, UserInfo userInfo) throws Exception {
        byte[] decryptedData = AESUtil.base64DecryptCBC(userInfo.getEncryptedData(), Base64.getDecoder().decode(sessionDto.getSessionKey()), Base64.getDecoder().decode(userInfo.getIv()));
        UserInfoDto userInfoDto = JSONObject.parseObject(decryptedData, UserInfoDto.class);
        if (property.getWechat().getAppid().equals(userInfoDto.getWatermark().getAppid())){
            return true;
        }
        return false;
    }

    private Code2SessionDto getWxSession(UserInfo userInfo) {
        Map<String,Object> param = new HashMap<>();
        param.put("appid",property.getWechat().getAppid());
        param.put("secret",property.getWechat().getSecret());
        param.put("jsCode",userInfo.getCode());
        String res = null;
        try {
            res = restTemplate.getForObject(url,String.class,param);
            if (res.contains("errcode")){
                ErrorDto dto = JSONObject.parseObject(res,ErrorDto.class);
                LOGGER.error("请求登陆凭证失败，错误码：{}",dto.getErrcode());
                //TO DO  重试？
            }else {
                Code2SessionDto dto = JSONObject.parseObject(res,Code2SessionDto.class);
                LOGGER.info(dto.toString());
                return dto;
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
