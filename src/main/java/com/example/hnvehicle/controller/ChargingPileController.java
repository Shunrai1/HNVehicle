package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hnvehicle.bean.ChargingPile;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.Stop;
import com.example.hnvehicle.service.ChargingPileService;
import com.example.hnvehicle.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/24 13:56
 * @Version 1.0
 * @Description 充电桩控制器
 */
@Controller
public class ChargingPileController {
    @Autowired
    ChargingPileService chargingPileService;
    @Resource
    RedisCache redisCache;
    final static String STATE1="可用";
    final static String STATE2="不可用";
    /**
     * 添加充电桩
     * @param points 充电桩坐标集
     * @return
     */
    @RequestMapping("/addChargingPile")
    @ResponseBody
    public String addChargingPile(String points/*,String state*/){
        ChargingPile chargingPile = new ChargingPile();
        chargingPile.setLocality(points);
//        if(STATE1.equals(state)||STATE2.equals(state)||"".equals(state)){
//            chargingPile.setState(state);
//        }else {
//            return "添加失败";
//        }
        boolean save = chargingPileService.save(chargingPile);
        if(save){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }


    /**
     * 根据cpId 删除充电桩
     * @param cpId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteChargingPile")
    public String deleteChargingPile(String cpId){
        boolean b = chargingPileService.removeById(Integer.parseInt(cpId));
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /**
     * 得到所有的停车点
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllChargingPile")
    public List<ChargingPile> getAllChargingPile(){
        List<ChargingPile> reList = redisCache.queryDataFromCache("getAllChargingPile", ChargingPile.class);
        if(reList!=null){
            return reList;
        }else {
            List<ChargingPile> list = chargingPileService.list();
            //添加list到redis中
            redisCache.cacheDataInRedis("getAllChargingPile",list);
            return list;
        }
        //优化前
//        return  chargingPileService.list();
    }

    /**
     * 更新充电桩状态
     * @param cpId
     * @param state
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateChargingPile")
    public String updateChargingPile(String cpId,String state){
        UpdateWrapper<ChargingPile> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("cp_id",Integer.parseInt(cpId));
        if(!(STATE1.equals(state)|| STATE2.equals(state))){
            return "更新失败";
        }
        updateWrapper.set("state",state);
        boolean b = chargingPileService.update(null,updateWrapper);
        if(b){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }
}
