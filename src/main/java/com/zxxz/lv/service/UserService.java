package com.zxxz.lv.service;

import com.zxxz.lv.entity.User;

public interface UserService {
    /**
     * 查询用户名是否占用
     * @param userName
     * @return
     */
    boolean checkUserName(String userName);

    boolean saveUser(User user);
}
