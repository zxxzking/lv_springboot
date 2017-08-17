package com.zxxz.lv.job;

import com.zxxz.lv.dto.MailDto;
import com.zxxz.lv.service.UserService;
import com.zxxz.lv.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@EnableScheduling
public class ScheduledTest {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);
    @Autowired
    private UserService userService;


    @Scheduled(cron="0/5 * * * * ?")
    public void executeUploadTask() {
        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }

    @Scheduled(cron="0/10 * * * * ?")
    public void sendMail(){
        MailDto dto = new MailDto();
        MailUtils utils = new MailUtils();
        dto.setContent("hahaha");
        dto.setFromPerson("zxxz");
        dto.setToPerson("aaa");
        dto.setTargetMail("lvquan@paicaifu.com");
        dto.setSubject("hehe");
        try {
            MailUtils.doSendMsg(dto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
