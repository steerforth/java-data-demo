package com.steer.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.steer.demo.common.model.Result;
import com.steer.demo.model.Good;
import com.steer.demo.model.GoodDetail;
import com.steer.demo.service.GoodDetailService;
import com.steer.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodDetailService goodDetailService;

    @GetMapping("/hot")
    public Object hot(int page,int limit){
        Page<Good> goods = goodService.selectHotsByPage(page,limit);
        return Result.successReult(goods.getRecords());
    }

    /**
     *
     * @param request
     * @param id good_id
     * @return
     */
    @GetMapping("/code/{id}")
    public Object hot(HttpServletRequest request, long id){
        return Result.successReult();
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable long id){
//        Page<Good> goods = goodService.selectHotsByPage(page,limit);
//        return Result.successReult(goods.getRecords());
        GoodDetail detail = goodDetailService.selectByGoodId(id);
        return Result.successReult(detail);
    }
}
