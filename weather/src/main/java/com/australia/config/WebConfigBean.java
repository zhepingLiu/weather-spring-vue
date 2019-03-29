package com.australia.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class WebConfigBean {

    //配置多文件上传
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("100MB"); // KB,MB
        factory.setMaxRequestSize("110MB");
        return factory.createMultipartConfig();
    }

}
