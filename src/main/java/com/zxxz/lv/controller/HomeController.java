package com.zxxz.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lv on 2017/7/21.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "hello world";


    }
}
