package com.steer.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.steer.demo.common.model.Result;
import com.steer.demo.model.Coupon;
import com.steer.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponService service;

    @GetMapping("")
    public Object page(HttpServletRequest request,int page, int limit){
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        Page<Coupon> p = service.selectPageByUserId(page,limit, (Long) request.getAttribute("userId"));
        return Result.successReult(p.getRecords());
    }
}
