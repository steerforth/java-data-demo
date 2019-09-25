package com.steer.demo.xml;

import com.steer.demo.common.utils.WxUtil;
import com.steer.demo.common.xml.XmlUtil;
import com.steer.demo.wechat.dto.OrderParam;
import org.junit.Test;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-25 12:05
 */
public class XmlTest {
    @Test
    public void test(){
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
        String mch_id = "";
        //异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        String notify_url = "https://www.steer.com/wechat/order/back";
        //小程序类型 为常量
        String trade_type = "JSAPI";
        //用户识别号
        String openid = "";
        //商户平台设置的密钥key
        String key = "";

        OrderParam order =  new OrderParam();
        order.setDetail("{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }");
        order.setAppid("12334");
        order.setBody(body);
        order.setMchId(mch_id);
        order.setNonceStr(nonce_str);
        String xml =  XmlUtil.toXml(order);
        System.out.println(xml);

        OrderParam newOrder = XmlUtil.parseFromXml(OrderParam.class,xml);
        System.out.println(newOrder.getDetail());
    }
}
