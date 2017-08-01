package com.zxxz.lv.service.impl;

import com.zxxz.lv.entity.UserInfo;
import com.zxxz.lv.mapper.UserInfoMapper;
import com.zxxz.lv.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getById(int id) {
        return null;
    }

    @Override
    public UserInfo getByName(String name){
        return userInfoMapper.getByName(name).get(0);
    }

    @Override
    public int saveUser(UserInfo userInfo) {
        return 0;
    }


    @Override
    public boolean checkUserName(String userName){
        List list = userInfoMapper.getByName(userName);
        if(list == null||list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public List<UserInfo> count(String userName){
        return userInfoMapper.count(userName);
    }
    @Override
    public List<UserInfo> get(String userName){ return userInfoMapper.getByName(userName);}


}
