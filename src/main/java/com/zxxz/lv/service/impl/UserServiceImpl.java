package com.zxxz.lv.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.zxxz.lv.entity.User;
import com.zxxz.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private DbHelper dbHelper;
    @Override
    public boolean checkUserName(String userName){
        String sql = "select * from user where name=? and isactive = '1'";
        User user = dbHelper.queryForObject(sql, User.class, userName);
        if(null != user){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public boolean saveUser(User user){
        return dbHelper.insert(user);
    }


}
