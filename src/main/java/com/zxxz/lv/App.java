package com.zxxz.lv;

import com.zxxz.lv.listener.TestDemo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
//@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.zxxz.lv.mapper")
public class App{





    public static void main( String[] args ){
        SpringApplication.run(App.class,args);

    }
    //@RequestMapping("/")
    public String entry(){
        return "redirect:/index";
    }
 /*   @RequestMapping("/error")
    public String error(){return "error";}*/

}
