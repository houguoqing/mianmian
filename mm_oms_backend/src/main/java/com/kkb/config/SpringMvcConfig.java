package com.kkb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("pages/index");//主页面
        registry.addViewController("/login").setViewName("login");//登录页
        registry.addViewController("/userList").setViewName("pages/userList");//用户列表
        registry.addViewController("/comList").setViewName("pages/comList");//企业列表
        registry.addViewController("/industryList").setViewName("pages/industryList");//方向列表
        registry.addViewController("/questionBasicList").setViewName("pages/questionBasicList");
        registry.addViewController("/questionClassicList").setViewName("pages/questionClassicList");
        registry.addViewController("/courseList").setViewName("pages/courseList");
    }
}
