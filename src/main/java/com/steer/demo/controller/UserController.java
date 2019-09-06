package com.steer.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.steer.demo.common.model.Result;
import com.steer.demo.model.User;
import com.steer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:44
 */
@RestController()
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/aa/{name}")
    public Object getByName(@PathVariable String name){
        EntityWrapper wrapper = new EntityWrapper<>();
        wrapper.eq("name",name);
        User entity = userService.selectOne(wrapper);
        return Result.successReult(entity);
    }

    @GetMapping("")
    public Object getById(String id){
        User entity = userService.selectById(id);
        return Result.successReult(entity);
    }

    @GetMapping("/test")
    public Object test(String name){
        User entity = userService.test(name);
        return Result.successReult(entity);
    }


}
