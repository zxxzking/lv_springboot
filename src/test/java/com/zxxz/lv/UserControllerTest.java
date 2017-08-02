package com.zxxz.lv;

import com.zxxz.lv.controller.UserController;
import com.zxxz.lv.entity.Country;
import com.zxxz.lv.service.CountryService;
import com.zxxz.lv.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    public MockHttpServletRequest request;
    public MockHttpServletResponse response;

    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }


    @Test
    public void test1(){
        //userService.checkUserName("zxxzking");
        //userService.count("5","1");
        request.setParameter("pageSize","5");
        request.setParameter("pageNum","1");

        Map map = userController.test(request, response);
        for (Object set:map.keySet()) {
            System.out.println(map.get(set));

        }
    }

    @Test
    public void test2(){
        Country byId = countryService.getById(5);
        System.out.println(byId);
    }


}
