package com.zxxz.lv.service.impl;

import com.zxxz.lv.entity.UserInfo;
import com.zxxz.lv.mapper.UserInfoMapper;
import com.zxxz.lv.mapper.UserMapper;
import com.zxxz.lv.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo getById(int id){
        return userInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public UserInfo getByName(String name){
        return userInfoMapper.getByName(name);
    }
}
