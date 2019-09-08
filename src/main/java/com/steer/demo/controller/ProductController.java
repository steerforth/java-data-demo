package com.steer.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.steer.demo.common.model.Result;
import com.steer.demo.model.Good;
import com.steer.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private GoodService goodService;

    @GetMapping("/hot")
    public Object hot(int page,int limit){
        Page<Good> goods = goodService.selectHotsByPage(page,limit);
        return Result.successReult(goods.getRecords());
    }
}
