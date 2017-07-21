package com.zxxz.lv.controller;

import com.zxxz.lv.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv on 2017/7/21.
 */
@Controller
public class MainController {

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("name","zxxz");
        return "index";
    }
    @GetMapping(value = "/jquery")
    public String jquery(){
        return "jquery";
    }
    @PostMapping(value = "/postData")
    @ResponseBody
    public Map<String,Object> postData(String no,int quantity,String date){
        System.out.println("no:" + no);
        System.out.println("quantity:" + quantity);
        System.out.println("date:" + date);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("msg", "ok");
        map.put("quantity", quantity);
        map.put("no", no);
        map.put("date", date);
        return map;
    }

    @PostMapping("/postJson")
    @ResponseBody
    public Map<String, Object> postJson(@RequestBody Order order) {
        System.out.println("order no:" + order.getNo());
        System.out.println("order quantity:" + order.getQuantity());
        System.out.println("order date:" + order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("value", order);
        return map;
    }

}
