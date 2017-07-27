package com.zxxz.lv.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 启动容器时监听日志文件大小 超过200m清空
 */
public class LogFileListener implements ServletContextListener {


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

    }
}
