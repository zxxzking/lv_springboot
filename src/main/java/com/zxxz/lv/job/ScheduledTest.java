package com.zxxz.lv.job;

import com.zxxz.lv.dto.MailDto;
import com.zxxz.lv.entity.Job;
import com.zxxz.lv.service.JobService;
import com.zxxz.lv.service.UserService;
import com.zxxz.lv.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ScheduledTest implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);
    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;

    private final String cron1="";

    @Scheduled(cron="0/5 * * * * ?")
    public void executeUploadTask() {
        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }

    //@Scheduled(cron="0/10 * * * * ?")
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

    @PostConstruct
    public void init() throws Exception{
        Class clazz = this.getClass();
        String clazzName = clazz.getName();
        String[] split = clazzName.split("\\.");
        clazzName = split[split.length-1];
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            Scheduled annotation = method.getAnnotation(Scheduled.class);
            if(annotation!=null){
                Job job = jobService.getJob(clazzName, method.getName());
                if(null == job){
                    continue;
                }
                Field cron1 = clazz.getDeclaredField("cron1");
                cron1.setAccessible(true);
                cron1.set(this,job.getCron());
                logger.info(annotation.cron());
            }
        }
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
}
