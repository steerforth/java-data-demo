package com.steer.demo.service;

import com.steer.demo.DemoApplicationTests;
import com.steer.demo.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService service;

    @Test
    public void selectTest(){
        User user = service.selectByOpenid("oA7cI0aHhaVe9LVdFSOXDWlZtJIw");
        LOGGER.info(user.toString());
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setCity("Hangzhou");
        user.setNickName("aaa");
        user.setOpenid("fddd");
        user.setGender((short) 0);
        service.insert(user);
        LOGGER.info("id:{}",user.getId());
    }
}
