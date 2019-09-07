package com.steer.demo.http;

import com.alibaba.fastjson.JSONObject;
import com.steer.demo.DemoApplicationTests;
import com.steer.demo.common.property.ApplicationProperty;
import com.steer.demo.wechat.dto.ErrorDto;
import com.steer.demo.wechat.dto.Code2SessionDto;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HttpTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(HttpTest.class);
    @Autowired
    private ApplicationProperty property;
    @Autowired
    private RestTemplate template;

    @Test
    public void test() {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={jsCode}&grant_type=authorization_code";
        Map<String,Object> param = new HashMap<>();

        param.put("appid",property.getWechat().getAppid());
        param.put("secret",property.getWechat().getSecret());
        //wx.login
        param.put("jsCode","001Mke9k286OkE0glmak2A7s9k2Mke9x");
        //{"errcode":40029,"errmsg":"invalid code, hints: [ req_id: mgdeEyXBe-hLefHa ]"}
        String res = null;
        try {
            res = template.getForObject(url,String.class,param);
            if (res.contains("errcode")){
                ErrorDto dto = JSONObject.parseObject(res,ErrorDto.class);
                LOGGER.error("请求登陆凭证失败，错误码：{}",dto.getErrcode());
            }else {

                Code2SessionDto dto = JSONObject.parseObject(res,Code2SessionDto.class);
                LOGGER.info(dto.toString());
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
    }
}
