package com.steer.demo.common.config;

import com.steer.demo.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //v2后的都是swagger2的url
    private static List<String> filterUrls = Arrays.asList("/webjars/**","/swagger-resources/**");

    //让bean在拦截器前加载，不然拦截器里autowired注入的bean会为null
    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    //增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getSecurityInterceptor())    //指定拦截器类
                .addPathPatterns("/**").excludePathPatterns(filterUrls);  //指定该类拦截的url
//        registry.addInterceptor(getErrorPageInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}

