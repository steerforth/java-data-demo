package com.steer.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.steer.demo.common.property.ApplicationProperty;
import com.steer.demo.common.utils.AESUtil;
import com.steer.demo.dto.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor implements HandlerInterceptor {
    private Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);
    @Autowired
    private ApplicationProperty property;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        this.prepareResponse(res);

        this.checkAuthHeader(req);

        LOGGER.debug("{} requesting from [{}]",req.getRequestURI(),req.getRemoteAddr());

        return true;
    }

    private void checkAuthHeader(HttpServletRequest req) {
        String authHeader = req.getHeader("Authori-zation");
        if (authHeader != null){
            LOGGER.debug("authHeader:{}",authHeader);
            String[] arr = authHeader.split(" ");
            if (arr.length == 2){
                Session session = null;
                try {
                    session = JSONObject.parseObject(AESUtil.base64Decrypt(arr[1],property.getAesKey()),Session.class,null);
                    if (session != null){
                        req.setAttribute("userId",session.getUserId());
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }

            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private HttpServletResponse prepareResponse(HttpServletResponse res) {
        res.setCharacterEncoding("utf-8");
        res.setDateHeader("Expires", 0);//不在浏览器中缓存
        res.setHeader("Pragma", "no-cache");
        res.addHeader("Cache-Control", "no-cache");
        res.addHeader("Cache-Control", "no-store");
        res.addHeader("Cache-Control", "must-revalidate");
        return res;
    }
}
