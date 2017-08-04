package com.zxxz.lv.listener;


import com.zxxz.lv.service.BaseService;
import com.zxxz.lv.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(OnlineNumListener.class);

    private BaseService baseService = null;


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        baseService = SpringContextHolder.getBean(BaseService.class);
        try {
            int i = baseService.doAdd();
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("更新在线人数异常");
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        baseService = SpringContextHolder.getBean(BaseService.class);
        try {
            int i = baseService.doDestroy();
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("更新在线人数异常");
        }
    }
}
