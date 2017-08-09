package com.zxxz.lv;

import com.zxxz.lv.controller.UserController;
import com.zxxz.lv.service.BaseService;
import com.zxxz.lv.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


public class UserControllerTest extends TestCase{

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;


    @Autowired
    private BaseService baseService;




    @Test
    public void test1(){

    }



}
