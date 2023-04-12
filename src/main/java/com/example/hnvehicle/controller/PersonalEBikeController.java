package com.example.hnvehicle.controller;

import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.service.PersonalEBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/11 13:13
 * @Version 1.0
 * @Description
 */
@Controller
public class PersonalEBikeController {
    @Autowired
    PersonalEBikeService personalEBikeService;



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
    public String addPersonalEBike(@RequestParam("no")String no, @RequestParam("ownership") String ownership,
                                   @RequestParam("timeInterval")String timeInterval, @RequestParam("campus")String campus,
                                   @RequestParam("color")String color, @RequestParam("lng")String lng, @RequestParam("lat")String lat) {
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
     * 获得所有的个人电动车对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllPersonalEBike")
    public List<PersonalEBike> getAllPersonalEBike(){
        List<PersonalEBike> list = personalEBikeService.list();
        return list;
    }

    /**
     * 按主键id删除个人电动车
     * @param pebId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletePersonalEBike")
    public String deletePersonalEBike(String pebId) {
        boolean b = personalEBikeService.removeById(Integer.parseInt(pebId));
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
