package com.steer.demo.controller;

import com.steer.demo.cache.CacheStorage;
import com.steer.demo.common.model.Result;
import com.steer.demo.dto.TokenDto;
import com.steer.demo.dto.UserInfo;
import com.steer.demo.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private Logger LOGGER = LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private WechatService wechatService;
    @Autowired
    private CacheStorage cacheStorage;
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
    public Object mpAuth(@RequestBody UserInfo userInfo) throws Exception {
        TokenDto dto = wechatService.authAndCheck(userInfo);
        return Result.successReult(dto);
    }

    @PostMapping("/set_form_id")
    public Object saveFormId(HttpServletRequest request, @RequestBody String formId){
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        //TO DO 存在缓存redis中,有个过期时间
        cacheStorage.addForm((Long)request.getAttribute("userId"),formId);
        LOGGER.info("save form id:{}",formId);
        return Result.successReult();
    }


}
