package com.zxxz.lv;

import com.zxxz.lv.controller.WeatherController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * Hello world!
 *
 */
//@Controller
@SpringBootApplication
public class App{

    public static void main( String[] args ){
        SpringApplication.run(App.class,args);
        new WeatherController();

    }

}
