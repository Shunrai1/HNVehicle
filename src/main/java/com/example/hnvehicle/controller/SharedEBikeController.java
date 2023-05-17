package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.SharedEBikeService;
import com.example.hnvehicle.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/11 13:14
 * @Version 1.0
 * @Description
 */
@Controller
public class SharedEBikeController {
    @Autowired
    SharedEBikeService sharedEBikeService;
    @Resource
    RedisCache redisCache;
    final String state1="维修中";
    final String state2="正在使用中";


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
        //判断no是否合法，”NH.000000” 到 ”HN.999999"之间的格式，并查询是否有重复车牌
//        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("no",no);
//        long count = sharedEBikeService.count(queryWrapper);
//        int i;
//        try {
//            i = Integer.parseInt(no.substring(3));
//        } catch (NumberFormatException e) {
//            return "添加失败,no的格式错误";
//        }
//        if(!(no.length()==9 &&no.startsWith("HN.") &&((i>=600000&&i<=699999)||(i>=800000&&i<=899999)))){
//            return "添加失败，no的格式错误";
//        }
//        if (count!=0){
//            return "添加失败，已经存在该车牌";
//        }
        sharedEBike.setNo(no);
        //添加的状态只能为这两种
//        if(!(state1.equals(state)|| state2.equals(state))){
//            return "添加失败";
//        }
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
        List<SharedEBike> reList = redisCache.queryDataFromCache("getAllSharedEBike", SharedEBike.class);
        if(reList!=null){
            return reList;
        }else {
            QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("state", state2);
            List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
            //添加list到redis中
            redisCache.cacheDataInRedis("getAllSharedEBike",list);
            return list;
        }
//        优化前：
//        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", state2);
//        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
//        return list;
    }


    /**
     * 获得所有维修中的共享电动车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBadSharedEBike")
    public List<SharedEBike> getBadSharedEBike(){
        List<SharedEBike> reList = redisCache.queryDataFromCache("getBadSharedEBike", SharedEBike.class);
        if(reList!=null){
            return reList;
        }else {
            QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("state", state1);
            List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
            //添加list到redis中
            redisCache.cacheDataInRedis("getBadSharedEBike",list);
            return list;
        }
        //优化前
//        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", state1);
//        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
//        return list;
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
//        if(!(state1.equals(state)|| state2.equals(state))){
//            return "更新失败";
//        }
        updateWrapper.set("state",state);
        boolean b = sharedEBikeService.update(null,updateWrapper);
        if(b){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @ResponseBody
    @RequestMapping("/getSharedEBikeNum")
    public Long getSharedEBikeNum(){
        long count = sharedEBikeService.count();
        return count;
    }

    @ResponseBody
    @RequestMapping("/getRepairSharedEBikeNum")
    public Long getRepairSharedEBikeNum(){
        QueryWrapper<SharedEBike> sharedEBikeQueryWrapper = new QueryWrapper<>();
        sharedEBikeQueryWrapper.eq("state",state1);
        return sharedEBikeService.count(sharedEBikeQueryWrapper);
    }

    @ResponseBody
    @RequestMapping("/getUseSharedEBikeNum")
    public Long getUseSharedEBikeNum(){
        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",state2);
        return sharedEBikeService.count(queryWrapper);
    }
}
