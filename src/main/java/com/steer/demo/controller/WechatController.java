package com.steer.demo.controller;

import com.steer.demo.common.model.Result;
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
    /**
     * 获取微信头像
     * @return
     */
    @RequestMapping("/get_logo")
    public Object getLogo(){
        Map<String,Object> map = new HashMap<>();
        map.put("logo_url","http://127.0.0.1:8000/demo/static/images/logo.jpeg");
        return Result.successReult(map);
    }
}
