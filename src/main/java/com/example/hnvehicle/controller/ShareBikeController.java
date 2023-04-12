package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.service.SharedBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
public class ShareBikeController {

    @Autowired
    SharedBikeService sharedBikeService;
    final String state1="维修中";
    final String state2="正在使用中";
    final String state3="停车中";


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
        sharedBike.setNo(no);
        if(!(state1.equals(state)|| state2.equals(state)|| state3.equals(state))){
            return "添加失败";
        }
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
        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "正在使用中").or().eq("state","停车中");
        List<SharedBike> list = sharedBikeService.list(queryWrapper);
        return list;
    }

    /**
     * 获得所有维修中的共享单车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBadSharedBike")
    public List<SharedBike> getBadSharedBike(){
        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "维修中");
        List<SharedBike> list = sharedBikeService.list(queryWrapper);
        return list;
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
        if(!(state1.equals(state)|| state2.equals(state)|| state3.equals(state))){
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
}
