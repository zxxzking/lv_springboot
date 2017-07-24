package com.zxxz.lv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.zxxz.lv.mapper")
public class App{
    public static void main( String[] args ){
        SpringApplication.run(App.class,args);

    }
}
