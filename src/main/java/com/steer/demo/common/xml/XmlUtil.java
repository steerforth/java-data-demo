package com.steer.demo.common.xml;

import com.steer.demo.wechat.dto.OrderParam;
import com.steer.demo.wechat.dto.OrderResponse;
import com.thoughtworks.xstream.XStream;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-25 12:02
 */
public class XmlUtil {
    private static final XStream xStream = XStreamFactory.getXStream();
    /**
     * 对象转xml
     * @param obj 对象
     * @return
     */
    public static String toXml(Object obj) {
        xStream.processAnnotations(obj.getClass());
        xStream.ignoreUnknownElements();
        return xStream.toXML(obj);
    }

    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        xStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{OrderParam.class, OrderResponse.class});
        //处理注解
        xStream.processAnnotations(clazz);
        xStream.ignoreUnknownElements();
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
         T t = (T)xStream.fromXML(xml);
        return t;
    }


}
