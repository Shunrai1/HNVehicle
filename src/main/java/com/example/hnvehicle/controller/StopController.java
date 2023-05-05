package com.example.hnvehicle.controller;

import com.example.hnvehicle.bean.Stop;
import com.example.hnvehicle.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/24 13:55
 * @Version 1.0
 * @Description 停车点控制器
 */
@Controller
public class StopController {
    @Resource
    StopService stopService;

    /**
     * 添加停车点
     * @param points 停车点坐标集
     * @return
     */
    @RequestMapping("/addStop")
    @ResponseBody
    public String addStop(String points){
        Stop stop = new Stop();
        stop.setLocality(points);
        boolean save = stopService.save(stop);
        if(save){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }


    /**
     * 根据sId 删除停车点
     * @param sId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteStop")
    public String deleteStop(String sId){
        boolean b = stopService.removeById(Integer.parseInt(sId));
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
    @RequestMapping("/getAllStop")
    public List<Stop> getAllStop(){
        return  stopService.list();
    }
}
