package com.steer.demo.common.utils;

import org.dom4j.*;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class WxUtil {

      /**
      * Util工具类方法
      * 获取一定长度的随机字符串，范围0-9，a-z
      * @param length：指定字符串长度
      * @return 一定长度的随机字符串
      */
    public static String getRandomStrByLen(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 按照参数名ASCII码从小到大排序（字典序）
     * 即key1=value1&key2=value2…）拼接成字符串
     * 里面不能有空值
     * @param packageParams
     * @return
     */
    public static String createLinkString(Map<String,String> packageParams) {
        if (packageParams.size() ==0){
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        packageParams.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry->{
            if (!StringUtil.isBlank(entry.getValue())) {
                buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        });
        return buffer.deleteCharAt(buffer.toString().length()-1).toString();
    }


    /**  
      * 签名字符串  
      * @param text需要签名的字符串  
      * @param key 密钥  
      * @param input_charset编码格式  
      * @return 签名结果  （大写）
      */
    public static String sign(String text, String key, String input_charset) throws UnsupportedEncodingException {
        text = text + "&key=" + key;
        return DigestUtils.md5DigestAsHex(text.getBytes(input_charset)).toUpperCase();
    }

    public static String buildXmlParam(Map<String, String> packageParams,String sign){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml version=\"1.0\" encoding=\"gbk\">").
                append("<appid>").append(packageParams.get("appid")).append("</appid>").
                append("<body><![CDATA[").append(packageParams.get("body")).append("]]></body>").
                append("<mch_id>").append(packageParams.get("mch_id")).append("</mch_id>").
                append("<nonce_str>").append(packageParams.get("nonce_str")).append("</nonce_str>").
                append("<notify_url>").append(packageParams.get("notify_url")).append("</notify_url>").
                append("<openid>").append(packageParams.get("openid")).append("</openid>").
                append("<out_trade_no>").append(packageParams.get("out_trade_no")).append("</out_trade_no>").
                append("<spbill_create_ip>").append(packageParams.get("spbill_create_ip")).append("</spbill_create_ip>").
                append("<total_fee>").append(packageParams.get("total_fee")).append("</total_fee>").
                append("<trade_type>").append(packageParams.get("trade_type")).append("</trade_type>").
                append("<sign>").append(sign).append("</sign>").
                append("</xml>");
        return buffer.toString();
    }

    public static Map<String, String> doXmlParse(String xml) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        Map<String,String> data = new HashMap<>(rootElement.elements().size());
        Iterator it = rootElement.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            element.getQName().getName();
            element.getText();
            data.put(element.getQName().getName(),element.getText());
        }
        return data;
    }


}
