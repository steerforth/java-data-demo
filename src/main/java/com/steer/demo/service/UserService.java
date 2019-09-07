package com.steer.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.steer.demo.model.User;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:47
 */
public interface UserService extends IService<User> {
    User test(String name);
    User selectByOpenid(String openid);
}
