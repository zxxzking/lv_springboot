package com.zxxz.lv.service.impl;

import com.zxxz.lv.entity.Country;
import com.zxxz.lv.mapper.CountryMapper;
import com.zxxz.lv.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public Country getById(int id){
        return countryMapper.getById(id);
    }
}
