package com.zxxz.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lv on 2017/7/21.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String index(){
        return "Hello World";
    }

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/weather")
    public String weather() {
        return "weather";
    }
}
