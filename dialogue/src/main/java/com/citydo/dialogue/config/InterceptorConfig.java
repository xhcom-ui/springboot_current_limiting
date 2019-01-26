package com.citydo.dialogue.config;

import com.citydo.dialogue.service.AccessLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 * @author nick
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 添加拦截规则
        registry.addInterceptor(new AccessLimitInterceptor())
                //添加需要拦截请求的路径
                .addPathPatterns("/**");
               //swagger2 放行 .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
               //.excludePathPatterns("/*")
               //去除拦截请求的路径
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/");
    }



}
