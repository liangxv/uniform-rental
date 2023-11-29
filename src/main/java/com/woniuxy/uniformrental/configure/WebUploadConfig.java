package com.woniuxy.uniformrental.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebUploadConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath; //图片所在地址

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:" +
                uploadPath);

    }
}
