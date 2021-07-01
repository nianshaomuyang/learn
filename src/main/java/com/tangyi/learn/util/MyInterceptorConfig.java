package com.tangyi.learn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Value("${cbs.imagesPath}")
    private String UPLOAD_FOLDER;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(UPLOAD_FOLDER);
        registry.addResourceHandler("/FILM/**").addResourceLocations(UPLOAD_FOLDER);
    }
}
