package com.zxxz.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {




    @RequestMapping("/weather")
    public String index() {
        return "weather";
    }
}
