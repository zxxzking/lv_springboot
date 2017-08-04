package com.zxxz.lv.service.impl;

import com.zxxz.lv.mapper.BaseMapper;
import com.zxxz.lv.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseMapper baseMapper;

    @Override
    public int doAdd(){
        return baseMapper.doAddOnlineUser();
    }
    @Override
    public int doDestroy(){
        return baseMapper.doDestroyOnlineUser();
    }
    @Override
    public int doClean(){
        return baseMapper.doClean();
    }


}
