package com.steer.demo.controller;

import com.steer.demo.common.model.Result;
import com.steer.demo.dto.TokenDto;
import com.steer.demo.dto.UserInfo;
import com.steer.demo.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 19:56
 */
@RestController()
@RequestMapping("/api/wechat")
public class WechatController {
    @Autowired
    private WechatService wechatService;

    /**
     * 获取微信头像
     * @return
     */
    @GetMapping("/get_logo")
    public Object getLogo(){
        Map<String,Object> map = new HashMap<>();
        map.put("logo_url","http://127.0.0.1:8000/demo/static/images/logo.jpeg");
        return Result.successReult(map);
    }

    /**
     * 微信登陆
     * @return
     */
    @PostMapping("/mp_auth")
    public Object mpAuth(UserInfo userInfo) throws Exception {
        TokenDto dto = wechatService.authAndCheck(userInfo);
        return Result.successReult(dto);
    }
}
