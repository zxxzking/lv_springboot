package com.zxxz.lv;

import com.zxxz.lv.entity.User;
import com.zxxz.lv.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        User user = new User();
        int a = (int) Math.random()*100;
        user.setName("aa"+a);
        user.setPassWord("ccc");
        userService.saveUser(user);
    }



}
