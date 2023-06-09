package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.SharedBikeService;
import com.example.hnvehicle.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ShareBikeController {

    @Autowired
    SharedBikeService sharedBikeService;
    @Resource
    RedisCache redisCache;
    final String state1="维修中";
    final String state2="正在使用中";



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
    public String addSharedBike(@RequestParam("no")String no, @RequestParam("state") String state,
                                @RequestParam("monthlyUsageTimes")String monthlyUsageTimes,
                                @RequestParam("lng")String lng, @RequestParam("lat")String lat) {
        SharedBike sharedBike = new SharedBike();
        //判断no是否合法，”NH.000000” 到 ”HN.999999"之间的格式，并查询是否有重复车牌
//        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("no",no);
//        long count = sharedBikeService.count(queryWrapper);
//        int i;
//        try {
//            i = Integer.parseInt(no.substring(3));
//        } catch (NumberFormatException e) {
//            return "添加失败,no的格式错误";
//        }
//        if(!(no.length()==9&& no.startsWith("HN.")&&(i>=700000&&i<=799999))){
//            return "添加失败，no的格式错误";
//        }
//        if (count!=0){
//            return "添加失败，已经存在该车牌";
//        }
        sharedBike.setNo(no);
        //添加的状态只能为这两种
//        if(!(state1.equals(state)|| state2.equals(state))){
//            return "添加失败";
//        }
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
     * 获得所有的共享单车对象(可用的)
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllSharedBike")
    public List<SharedBike> getAllSharedBike(){
        List<SharedBike> reList = redisCache.queryDataFromCache("getAllSharedBike", SharedBike.class);
        if(reList!=null){
            return reList;
        }else {
            QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("state", state2);
            List<SharedBike> list = sharedBikeService.list(queryWrapper);
            //添加list到redis中
            redisCache.cacheDataInRedis("getAllSharedBike",list);
            return list;
        }
        //优化前
//        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", state2);
//        List<SharedBike> list = sharedBikeService.list(queryWrapper);
//        return list;
    }

    /**
     * 获得所有维修中的共享单车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBadSharedBike")
    public List<SharedBike> getBadSharedBike(){
        List<SharedBike> reList = redisCache.queryDataFromCache("getBadSharedBike", SharedBike.class);
        if(reList!=null){
            return reList;
        }else {
            QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("state", state1);
            List<SharedBike> list = sharedBikeService.list(queryWrapper);
            //添加list到redis中
            redisCache.cacheDataInRedis("getBadSharedBike",list);
            return list;
        }
        //优化前
//        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", state1);
//        List<SharedBike> list = sharedBikeService.list(queryWrapper);
//        return list;
    }

    /**
     * 按主键id删除共享单车
     * @param sbId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteSharedBike")
    public String deleteSharedBike(String sbId){
        boolean b = sharedBikeService.removeById(Integer.parseInt(sbId));
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /**
     * 更新共享单车状态
     * @param sbId
     * @param state
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSharedBike")
    public String updateSharedBike(String sbId,String state){
        UpdateWrapper<SharedBike> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("sb_id",Integer.parseInt(sbId));
        if(!(state1.equals(state)|| state2.equals(state))){
            return "更新失败";
        }
        updateWrapper.set("state",state);
        boolean b = sharedBikeService.update(null,updateWrapper);
        if(b){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @ResponseBody
    @RequestMapping("/getSharedBikeNum")
    public Long getSharedBikeNum(){
        long count = sharedBikeService.count();
        return count;
    }

    @ResponseBody
    @RequestMapping("/getRepairSharedBikeNum")
    public Long getRepairSharedBikeNum(){
        QueryWrapper<SharedBike> sharedEBikeQueryWrapper = new QueryWrapper<>();
        sharedEBikeQueryWrapper.eq("state",state1);
        return sharedBikeService.count(sharedEBikeQueryWrapper);
    }

    @ResponseBody
    @RequestMapping("/getUseSharedBikeNum")
    public Long getUseSharedEBikeNum(){
        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",state2);
        return sharedBikeService.count(queryWrapper);
    }
}
