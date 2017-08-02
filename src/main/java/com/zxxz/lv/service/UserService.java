package com.zxxz.lv.service;

import com.zxxz.lv.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo getById(int id);

    UserInfo getByName(String name);

    int saveUser(UserInfo userInfo);

    boolean checkUserName(String userName);

    List<UserInfo> count(String pageSize, String pageNum);

    List<UserInfo> get(String userName);
}
