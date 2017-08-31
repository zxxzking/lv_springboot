package com.zxxz.lv.config;

import com.zxxz.lv.filter.CrossDomainFilter;
import com.zxxz.lv.listener.LogFileListener;
import com.zxxz.lv.listener.OnlineNumListener;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * servlet的一些配置
 */
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

    /**
     * session监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean onlineCountListenerBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        OnlineNumListener listener = new OnlineNumListener();
        bean.setListener(listener);
        return bean;
    }

    /**
     * Quartz监听
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean executorListener(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        QuartzInitializerListener listener = new QuartzInitializerListener();
        bean.setListener(listener);
        return bean;
    }




}
