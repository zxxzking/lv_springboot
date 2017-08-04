package com.zxxz.lv.listener;

import com.zxxz.lv.service.BaseService;
import com.zxxz.lv.service.impl.BaseServiceImpl;
import com.zxxz.lv.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * context监听器
 */
public class LogFileListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(LogFileListener.class);


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        File file = new File("D:/idea_workspace/log/spring.log");
        long length = file.length();
        long max = 1024*1024*200l;
        if(length>=max){
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        BaseService baseService = SpringContextHolder.getBean(BaseService.class);
        try {
            baseService.doClean();
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("在线人数清空异常");
        }
    }
}
