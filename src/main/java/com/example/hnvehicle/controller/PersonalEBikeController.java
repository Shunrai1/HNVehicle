package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.service.PersonalEBikeService;
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
 * @Date 2023/4/11 13:13
 * @Version 1.0
 * @Description
 */
@Controller
public class PersonalEBikeController {
    @Autowired
    PersonalEBikeService personalEBikeService;
    @Resource
    RedisCache redisCache;


    /**
     * 添加个人电动车
     * @param no
     * @param ownership
     * @param timeInterval
     * @param campus
     * @param color
     * @return
     */
    @ResponseBody
    @RequestMapping("/addPersonalEBike")
    public String addPersonalEBike(@RequestParam("no")String no, @RequestParam("ownership") String ownership,
                                   @RequestParam("timeInterval")String timeInterval, @RequestParam("campus")String campus,
                                   @RequestParam("color")String color) {
        PersonalEBike personalEBike = new PersonalEBike();
        //判断no是否合法，”NH.000000” 到 ”HN.999999"之间的格式，并查询是否有重复车牌
//        QueryWrapper<PersonalEBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("no",no);
//        long count = personalEBikeService.count(queryWrapper);
//        int i;
//        try {
//             i = Integer.parseInt(no.substring(3));
//        } catch (NumberFormatException e) {
//            return "添加失败,no的格式错误";
//        }
//        if(!(no.length()==9&& no.startsWith("HN.")&&(i>=100000&&i<=599999))){
//            return "添加失败，no的格式错误";
//        }
//        if (count!=0){
//            return "添加失败，已经存在该车牌";
//        }
        personalEBike.setNo(no);
        personalEBike.setOwnership(ownership);
        personalEBike.setTimeInterval(timeInterval);
        personalEBike.setCampus(campus);
        personalEBike.setColor(color);

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


    @ResponseBody
    @RequestMapping("/getPersonalEBikeNum")
    public Long getPersonalEBikeNum(){
        return personalEBikeService.count();
    }

    @ResponseBody
    @RequestMapping("/getPersonalEBikeNumByCampus")
    public Long getPersonalEBikeNumByCampus(String campus){
        QueryWrapper<PersonalEBike> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("campus",campus);
        queryWrapper.like("campus",campus);
        return personalEBikeService.count(queryWrapper);
    }
}
