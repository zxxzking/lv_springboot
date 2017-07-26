package com.zxxz.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping("/weather")
    public String index() {
        return "weather";
    }


    @GetMapping("/zxxz")
    public String get(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("userName","zxxzking");
        return "index";
    }
   /* @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }*/

}
