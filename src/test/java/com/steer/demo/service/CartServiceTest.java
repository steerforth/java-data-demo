package com.steer.demo.service;

import com.steer.demo.DemoApplicationTests;
import com.steer.demo.model.Cart;
import com.steer.demo.model.Good;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(CartServiceTest.class);

    @Autowired
    private CartService cartService;

    @Test
    public void test(){
        List<Cart> carts = cartService.selectValidListByUser(1l);
        Assert.assertNotEquals(0,carts.size());
        Good good = carts.get(0).getProductInfo();
        LOGGER.info(good.toString());
    }
}
