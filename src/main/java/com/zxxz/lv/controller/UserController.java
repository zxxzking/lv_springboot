package com.zxxz.lv.controller;

import com.zxxz.lv.entity.UserInfo;
import com.zxxz.lv.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @RequestMapping(value = "register")
    public String userRegister(HttpServletRequest request,HttpServletResponse response){


        return null;
    }





}
