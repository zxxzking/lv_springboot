package com.zxxz.lv.controller;

import com.zxxz.lv.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryService countryService;



    @RequestMapping(value = "get")
    public Object get(){
        return countryService.getById(5);
    }
}
