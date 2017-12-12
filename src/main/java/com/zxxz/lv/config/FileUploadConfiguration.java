package com.zxxz.lv.config;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 */
@Configuration
public class FileUploadConfiguration {


    @Bean
    public MultipartConfigElement configElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制
        factory.setMaxFileSize("256kb");
        // 设置总上传数据大小
        factory.setMaxRequestSize("512kb");
        // 设置文件存储路径
        // factory.setLocation("classpath:/source");


        return factory.createMultipartConfig();
    }

}
