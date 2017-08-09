package com.zxxz.lv.controller;

import com.zxxz.lv.entity.User;
import com.zxxz.lv.service.UserService;
import com.zxxz.lv.utils.JsonResponse;
import com.zxxz.lv.utils.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 校验用户名是否被占用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkUserName")
    @ResponseBody
    public String checkUserName(HttpServletRequest request,HttpServletResponse response){
        JsonResponse jsonResponse = null;
        Map map = new HashMap<String,Object>();
        String userName = request.getParameter("userName");
        if(StringUtils.isBlank(userName)){
            log.info("参数错误");
            jsonResponse = JsonResponse.buildSuccess("success",map);
            return jsonResponse.toJsonString();
        }else {
            // 返回true没被占用
            boolean b = userService.checkUserName(userName);
            map.put("flag", b);
            jsonResponse = JsonResponse.buildSuccess("success", map);
            return jsonResponse.toJsonString();
        }
    }



    @RequestMapping(value = "register")
    @ResponseBody
    public String register(HttpServletRequest request,HttpServletResponse response){
        JsonResponse jsonResponse = null;
        Map map = new HashMap<String,Object>();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(passWord)){
            jsonResponse = JsonResponse.buildFailure("参数错误");
            return jsonResponse.toJsonString();
        }
        User user = new User();
        user.setName(userName);
        user.setPassWord(passWord);
        boolean flag = true;
        try {
            flag = userService.saveUser(user);
            System.out.println("doRegister");
        } catch (Exception e) {
            flag = false;
            log.error("注册失败");
        }
        map.put("flag",flag);
        request.getSession().setAttribute("user",user);
        jsonResponse = JsonResponse.buildSuccess("success",map);
        return jsonResponse.toJsonString();
    }

}
