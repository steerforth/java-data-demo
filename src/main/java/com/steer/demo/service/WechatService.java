package com.steer.demo.service;

import com.steer.demo.dto.TokenDto;
import com.steer.demo.dto.UserInfo;

public interface WechatService {

    TokenDto authAndCheck(UserInfo userInfo) throws Exception;
}
