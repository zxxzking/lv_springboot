package com.zxxz.lv.controller;

import com.zxxz.lv.utils.GsonUtils;
import com.zxxz.lv.utils.HttpToolKit;
import com.zxxz.lv.utils.JsonResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/weather")
public class WeatherController {
    private static final String weatherUrl = "https://way.jd.com/he/freeweather";
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Value("${common.jdSecret}")
    private String jdSecret;


    @RequestMapping(value = "/queryWeather/v1.0", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getWeatherMsg(HttpServletRequest request, HttpServletResponse response) {

        String city = request.getParameter("city");

        Map result = new HashMap<String, Object>();
        JsonResponse jsonResponse = null;
        if(StringUtils.isBlank(city)){
            logger.info("参数错误");
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("city", city);
        params.put("appkey", jdSecret);
        String resp = HttpToolKit.doGet(weatherUrl, params);
        result = GsonUtils.fromJson(resp, Map.class);
        if(result!= null){
            if(!result.get("code").equals("10000")){
                jsonResponse = JsonResponse.buildFailure("查询失败");
            }else{
                jsonResponse=JsonResponse.buildSuccess("查询成功", result);
            }
        }else{
            jsonResponse=JsonResponse.buildFailure("无结果");
        }
        return jsonResponse.toJsonString();
    }

}
