package com.example.hnvehicle.controller;

import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.PersonalEBikeService;
import com.example.hnvehicle.service.SharedBikeService;
import com.example.hnvehicle.service.SharedEBikeService;
import com.example.hnvehicle.service.impl.PersonalEBikeServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:33
 * @Version 1.0
 * @Description
 */
@Controller
public class VehicleManageController {
    @Autowired
    PersonalEBikeService personalEBikeService;
    @Autowired
    SharedEBikeService sharedEBikeService;
    @Autowired
    SharedBikeService sharedBikeService;

    /**
     * 添加个人电动车
     * @param no
     * @param ownership
     * @param timeInterval
     * @param campus
     * @param color
     * @param lng
     * @param lat
     * @return
     */
    @ResponseBody
    @RequestMapping("/addPersonalEBike")
    public String addPersonalEBike(@RequestParam("no")String no,@RequestParam("ownership") String ownership,
                                 @RequestParam("timeInterval")String timeInterval,@RequestParam("campus")String campus,
                                 @RequestParam("color")String color,@RequestParam("lng")String lng,@RequestParam("lat")String lat) {
        PersonalEBike personalEBike = new PersonalEBike();
        personalEBike.setNo(no);
        personalEBike.setOwnership(ownership);
        personalEBike.setTimeInterval(timeInterval);
        personalEBike.setCampus(campus);
        personalEBike.setColor(color);
        personalEBike.setLng(Double.parseDouble(lng));
        personalEBike.setLat(Double.parseDouble(lat));
        boolean save = personalEBikeService.save(personalEBike);
        if(save){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 添加共享电动车
     * @param no
     * @param state
     * @param cumlativeUsageTime
     * @param monthlyUsageTimes
     * @param trail
     * @param color
     * @param battery
     * @param lng
     * @param lat
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSharedEBike")
    public String addSharedEBike(@RequestParam("no")String no,@RequestParam("state") String state,
                                   @RequestParam("cumlativeUsageTime")String cumlativeUsageTime,@RequestParam("monthlyUsageTimes")String monthlyUsageTimes,
                                   @RequestParam("trail")String trail,@RequestParam("color")String color,@RequestParam("battery")String battery,
                                 @RequestParam("lng")String lng,@RequestParam("lat")String lat) {
        SharedEBike sharedEBike = new SharedEBike();
        sharedEBike.setNo(no);
        sharedEBike.setState(state);
        sharedEBike.setCumlativeUsageTime(cumlativeUsageTime);
        sharedEBike.setMonthlyUsageTimes(Integer.parseInt(monthlyUsageTimes));
        sharedEBike.setTrail(trail);
        sharedEBike.setColor(color);
        sharedEBike.setBattery(Integer.parseInt(battery));
        sharedEBike.setLng(Double.parseDouble(lng));
        sharedEBike.setLat(Double.parseDouble(lat));
        boolean save = sharedEBikeService.save(sharedEBike);
        if(save){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 添加共享单车
     * @param no
     * @param state
     * @param monthlyUsageTimes
     * @param lng
     * @param lat
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSharedBike")
    public String addSharedBike(@RequestParam("no")String no,@RequestParam("state") String state,
                                 @RequestParam("monthlyUsageTimes")String monthlyUsageTimes,
                                 @RequestParam("lng")String lng,@RequestParam("lat")String lat) {
        SharedBike sharedBike = new SharedBike();
        sharedBike.setNo(no);
        sharedBike.setState(state);
        sharedBike.setMonthlyUsageTimes(Integer.parseInt(monthlyUsageTimes));
        sharedBike.setLng(Double.parseDouble(lng));
        sharedBike.setLat(Double.parseDouble(lat));
        boolean save = sharedBikeService.save(sharedBike);
        if(save){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 获得所有的个人电动车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllPersonalEBike")
    public List<PersonalEBike> getAllPersonalEBike(){
        List<PersonalEBike> list = personalEBikeService.list();
        return list;
    }

    
}
