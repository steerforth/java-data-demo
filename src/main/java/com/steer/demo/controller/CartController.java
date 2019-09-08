package com.steer.demo.controller;

import com.steer.demo.common.model.Result;
import com.steer.demo.dto.CartListDto;
import com.steer.demo.model.Cart;
import com.steer.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService service;

    @GetMapping("/list")
    public Object list(HttpServletRequest request){
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        List<Cart> validCarts = service.selectValidListByUser((Long) request.getAttribute("userId"));
        List<Cart> invalidCarts = service.selectInvalidListByUser((Long) request.getAttribute("userId"));
        CartListDto listDto = new CartListDto();
        listDto.setValid(validCarts);
        listDto.setInvalid(invalidCarts);
        return Result.successReult(listDto);
    }

    /**
     *
     * @param request
     * @param numType true 购物车数量；false 购物车产品数量
     * @return
     */
    @GetMapping("/count")
    public Object count(HttpServletRequest request,boolean numType) throws Exception {
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        int count;
        if (numType){
            count = service.selectCartCount((Long)request.getAttribute("userId"));
        }else{
            throw new Exception("暂时不支持");
        }
        return Result.successReult(count);
    }
}
