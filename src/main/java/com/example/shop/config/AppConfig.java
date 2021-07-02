package com.example.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import javax.annotation.Resource;

/**
 * 自定义配置类
 * @author sen
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/good/","/login","/loginAction","/register","/registerAction","/good/details","/upload/**","/lib/**");
    }

    /**
     * 自定义文件位置的映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\public\\upload\\";
        //upload/** 映射到对应resource下工程目录path
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + path);
    }
}
