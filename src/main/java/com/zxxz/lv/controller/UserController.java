package com.zxxz.lv.controller;

import com.zxxz.lv.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getById(HttpServletRequest request, HttpServletResponse response){
        return userService.getById(5).toString();
    }
}
