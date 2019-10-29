package com.garment.dapei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    /**
     * 爬虫获取当天的天气
     * @param dateTime 日期
     * @return 天气
     */
    @GetMapping("/weather")
    public String getWeather(String dateTime){
        return null;
    }
}
