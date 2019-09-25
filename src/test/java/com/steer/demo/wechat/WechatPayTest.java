package com.steer.demo.wechat;

import com.steer.demo.DemoApplicationTests;
import com.steer.demo.common.property.ApplicationProperty;
import com.steer.demo.common.utils.WxUtil;
import com.steer.demo.common.xml.XmlUtil;
import com.steer.demo.wechat.dto.OrderParam;
import com.steer.demo.wechat.dto.OrderResponse;
import com.steer.demo.wechat.dto.PayParamDto;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WechatPayTest extends DemoApplicationTests {
    private Logger LOGGER = LoggerFactory.getLogger(WechatPayTest.class);

    @Autowired
    private ApplicationProperty property;
    @Autowired
    private RestTemplate template;

    @Test
    public void test() throws UnsupportedEncodingException, URISyntaxException, DocumentException {
            //随机字符串
            String nonce_str = WxUtil.getRandomStrByLen(32);
            //商品名称 
//            String body = new String("天天爱消除-会员充值".getBytes("ISO-8859-1"),"UTF-8");
            //APP名字-商品概述
            String body = "天天爱消除-会员充值";
            //服务器ip
            String spbill_create_ip = "192.168.2.110";
            //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
            String out_trade_no = "";
            //支付金额，单位：分，不能带小数，这边需要转成字符串类型，否则后面的签名会失败
            String total_fee = "1";
            //微信支付分配的商户号
            String mch_id = "1";
            //异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
            String notify_url = "https://www.steer.com/wechat/order/back";
            //小程序类型 为常量
            String trade_type = "JSAPI";
            //用户识别号
            String openid = "1";
            //商户平台设置的密钥key
            String key = "1";

            OrderParam order = new OrderParam();
            order.setAppid(property.getWechat().getAppid());
            order.setMchId(mch_id);
            order.setNonceStr(nonce_str);
            order.setBody(body);
            order.setOutTradeNo(out_trade_no);
            order.setTotalFee(total_fee);
            order.setSpbillCreateIp(spbill_create_ip);
            order.setNotifyUrl(notify_url);
            order.setTradeType(trade_type);
            order.setOpenid(openid);

            Map<String, String> param = new HashMap<>();
            param.put("appid", property.getWechat().getAppid());
            param.put("body", body);
            param.put("mch_id", mch_id);
            param.put("nonce_str", nonce_str);
            param.put("notify_url", notify_url);
            param.put("openid", openid);
            param.put("out_trade_no", out_trade_no);//商户订单号
            param.put("spbill_create_ip", spbill_create_ip);
            param.put("total_fee", total_fee);
            param.put("trade_type", trade_type);


            String prestr = WxUtil.createLinkString(param); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            LOGGER.info("url拼接字符串:{}",prestr);

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String signValue = WxUtil.sign(prestr, key, "utf-8");
            LOGGER.info("======第一次签名:[{}],大小:{}=======",signValue,signValue.length());

//            String xml = WxUtil.buildXmlParam(param,signValue);
            order.setSign(signValue);
            String xml = XmlUtil.toXml(order);
            LOGGER.info("请求xml:[{}]",xml);

            String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf("text/xml"));
            HttpEntity<String> strEntity = new HttpEntity<>(xml,headers);

            String res = template.postForObject(new URI(url),strEntity,String.class);

            LOGGER.info("http res:{}",res);

            OrderResponse response = XmlUtil.parseFromXml(OrderResponse.class,res);

            if (response.getReturnCode().equals("SUCCESS")){
                    if (response.getReturnCode().equals("SUCCESS")){
                            PayParamDto paramDto = new PayParamDto();
                            paramDto.setTimestamp(System.currentTimeMillis()/1000);
                            paramDto.setNonceStr(response.getNonceStr());
                            paramDto.setPrepayId("prepay_id="+response.getPrepayId());
                            paramDto.setSignType("MD5");
                            String strSignTemp = paramDto.buildLinkStr();
                            LOGGER.info("sign 传入的参数:{}",strSignTemp);
                            String paySign = WxUtil.sign(strSignTemp, key, "utf-8");
                            LOGGER.info("sign 响应给前端:{}",paySign);
                            paramDto.setPaySign(paySign);
                    }else{
                            LOGGER.error("业务失败：错误码:{},错误描述:{}",response.getErrCode(),response.getErrCodeDes());
                    }
            }else{
                    LOGGER.error("请求失败：{}",response.getReturnMsg());
            }





    }
}
