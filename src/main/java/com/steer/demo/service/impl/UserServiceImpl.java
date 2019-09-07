package com.steer.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.steer.demo.dao.UserMapper;
import com.steer.demo.dto.UserInfo;
import com.steer.demo.model.User;
import com.steer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User test(String name) {
        return userMapper.test(name);
    }

    @Override
    public User selectByOpenid(String openid) {
        return userMapper.selectByOpenid(openid);
    }

}
