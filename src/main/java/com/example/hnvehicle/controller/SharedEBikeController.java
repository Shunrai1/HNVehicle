package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.SharedEBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/11 13:14
 * @Version 1.0
 * @Description
 */
public class SharedEBikeController {
    @Autowired
    SharedEBikeService sharedEBikeService;
    final String state1="维修中";
    final String state2="正在使用中";
    final String state3="停车中";

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
    public String addSharedEBike(@RequestParam("no")String no, @RequestParam("state") String state,
                                 @RequestParam("cumlativeUsageTime")String cumlativeUsageTime, @RequestParam("monthlyUsageTimes")String monthlyUsageTimes,
                                 @RequestParam("trail")String trail, @RequestParam("color")String color, @RequestParam("battery")String battery,
                                 @RequestParam("lng")String lng, @RequestParam("lat")String lat) {
        SharedEBike sharedEBike = new SharedEBike();
        sharedEBike.setNo(no);
        if(!(state1.equals(state)|| state2.equals(state)|| state3.equals(state))){
            return "添加失败";
        }
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
     * 获得所有的共享电动车对象(可用的)
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllSharedEBike")
    public List<SharedEBike> getAllSharedEBike(){
        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "正在使用中").or().eq("state","停车中");
        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
        return list;
    }


    /**
     * 获得所有维修中的共享电动车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBadSharedEBike")
    public List<SharedEBike> getBadSharedEBike(){
        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "维修中");
        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
        return list;
    }


    /**
     * 按主键id删除共享电动车
     * @param sebId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteSharedEBike")
    public String  deleteSharedEBike(String sebId){
        boolean b = sharedEBikeService.removeById(Integer.parseInt(sebId));
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /**
     * 更新共享电动车状态
     * @param sebId
     * @param state
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSharedEBike")
    public String updateSharedEBike(String sebId,String state){
        UpdateWrapper<SharedEBike> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("seb_id",Integer.parseInt(sebId));
        if(!(state1.equals(state)|| state2.equals(state)|| state3.equals(state))){
            return "更新失败";
        }
        updateWrapper.set("state",state);
        boolean b = sharedEBikeService.update(null,updateWrapper);
        if(b){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }
}
