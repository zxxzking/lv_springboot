package com.zxxz.lv.controller;

import com.zxxz.lv.entity.UserInfo;
import com.zxxz.lv.service.UserService;
import com.zxxz.lv.utils.SecurityUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;




    @RequestMapping(value = "checkUserName")
    @ResponseBody
    public Map checkUserName(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("userName");

        Map map = new HashMap<String,Object>();
        boolean check = userService.checkUserName(username);
        map.put("result",check);
        return map;
    }



    @RequestMapping(value = "register")
    @ResponseBody
    public Map userRegister(HttpServletRequest request,HttpServletResponse response){
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        Map map = new HashMap<String,Object>();
        UserInfo userInfo = new UserInfo();
        String newPassword = SecurityUtils.string2MD5(password);
        userInfo.setPassword(newPassword);
        userInfo.setUsername(username);
        // 默认普通用户
        userInfo.setUsertype("1");
        int i = userService.saveUser(userInfo);
        if(i!=1){
            map.put("code","1001");
            map.put("msg","注册失败，请稍后重试");
        }else{
            map.put("code","0000");
        }
        request.getSession().setAttribute("user",userInfo);
        return map;
    }

    @RequestMapping(value = "test1")
    @ResponseBody
    public Map test(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        Map map = new HashMap<String,Object>();
        List<UserInfo> count = userService.count(username);
        map.put("count",count);
        return map;
    }

    @RequestMapping(value = "test2")
    @ResponseBody
    public Map test2(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        Map map = new HashMap<String,Object>();
        List<UserInfo> count = userService.get(username);
        map.put("count",count);
        return map;
    }


}
