package com.steer.demo.service;

import com.steer.demo.DemoApplicationTests;
import com.steer.demo.model.GoodDetail;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodDetailServiceTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(GoodDetailServiceTest.class);

    @Autowired
    private GoodDetailService service;
    @Test
    public void test(){
        GoodDetail detail = service.selectByGoodId(5l);
        Assert.assertNotNull(detail);
    }
}
