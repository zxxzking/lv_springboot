package com.zxxz.lv.config;

import com.zxxz.lv.filter.CrossDomainFilter;
import com.zxxz.lv.listener.LogFileListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    /**
     * 配置一个处理跨域请求的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean domainCrossFilterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CrossDomainFilter filter = new CrossDomainFilter();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    /*
    注册一个监听器
     */
    @Bean
    public ServletListenerRegistrationBean logFileListenerBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        LogFileListener listener = new LogFileListener();
        bean.setListener(listener);
        return bean;
    }


}
