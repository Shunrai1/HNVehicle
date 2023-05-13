package com.example.hnvehicle.controller;

import com.example.hnvehicle.service.UsageRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Shunrai
 * @Date 2023/5/9 14:56
 * @Version 1.0
 * @Description
 */
@RestController
public class UsageRateController {
    @Resource
    private UsageRateService usageRateService;

    @RequestMapping("/getRate")
    public String getRate(String month){
        double rate = usageRateService.getRate(Integer.parseInt(month));
        return rate*100+"%";
    }
}
