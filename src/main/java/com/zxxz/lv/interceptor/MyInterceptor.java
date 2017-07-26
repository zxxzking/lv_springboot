package com.zxxz.lv.interceptor;

import com.zxxz.lv.entity.UserInfo;
import com.zxxz.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{


    private final UserService userService;
    /*
      此方法在请求处理前调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserInfo user = userService.getById(2);
        System.out.println(user.getUsername());
        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath);
        return true;
    }
    /*
        此方法在处理请求之后调用，在视图渲染前（dispatcherServlet渲染视图前）
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String userName = (String) httpServletRequest.getAttribute("userName");
        System.out.println(userName);
    }
    /*
    在整个请求处理结束后调用（dispatcherServlet渲染视图后）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public MyInterceptor(UserService userService) {
        this.userService = userService;
    }


}