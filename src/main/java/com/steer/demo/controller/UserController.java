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

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("")
    public Object user(HttpServletRequest request){
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        User entity = userService.selectById((Long) request.getAttribute("userId"));
        return Result.successReult(entity);
    }

    @GetMapping("/aa/{name}")
    public Object test(@PathVariable String name){
        EntityWrapper wrapper = new EntityWrapper<>();
        wrapper.eq("name",name);
        User entity = userService.selectOne(wrapper);
        return Result.successReult(entity);
    }

}
