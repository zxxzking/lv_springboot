package com.zxxz.lv;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hello world!
 *
 */
//@Controller
@SpringBootApplication
@EnableTransactionManagement //启动注解事物管理
public class App{

    public static void main( String[] args ){
        SpringApplication.run(App.class,args);

    }

}
