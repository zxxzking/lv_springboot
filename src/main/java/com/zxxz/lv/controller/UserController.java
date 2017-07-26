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


    @RequestMapping(value = "/get")
    @ResponseBody
    public String getById(HttpServletRequest request, HttpServletResponse response){

        return userService.getById(2).toString();
    }
    @RequestMapping(value = "text")
    public String get(Model model){
        UserInfo userInfo = userService.getById(3);
        model.addAttribute("name",userInfo.getUsername());
        return "text";
    }
    @RequestMapping(value = "login")
    public String login(Model model,HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        model.addAttribute("userName",userName);
        return "";
    }
}
