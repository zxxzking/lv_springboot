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

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping(value = "toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "index")
    public String toIndex(){
        return "index";
    }


}
