package com.example.hnvehicle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.PersonalEBikeService;
import com.example.hnvehicle.service.SharedBikeService;
import com.example.hnvehicle.service.SharedEBikeService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 个人电动车，共享电动车，共享单车相关测试
 */
@SpringBootTest
class HnVehicleApplicationTests {

    @Autowired
    PersonalEBikeService personalEBikeService;
    @Autowired
    SharedEBikeService sharedEBikeService;
    @Autowired
    SharedBikeService sharedBikeService;
    final String state1="维修中";
    final String state2="正在使用中";
    final String state3="停车中";

    @Test
    void contextLoads() {

    }

    /**
     * 添加测试
     */
    @Test
    void addTest01(){
        PersonalEBike personalEBike = new PersonalEBike();
        personalEBike.setNo("test2");
        personalEBike.setOwnership("我");
        personalEBike.setTimeInterval("2000-3453");

//        int save = personalEBikeService.addPersonalEBike(personalEBike);
        boolean save = personalEBikeService.save(personalEBike);
        if (save){
            System.out.println("添加成功！！");
        }
    }

    @Test
    void addTest02(){
        SharedEBike sharedEBike = new SharedEBike();
        sharedEBike.setNo("test");
        sharedEBike.setState("可以用");
        sharedEBike.setCumlativeUsageTime("39");
        sharedEBike.setMonthlyUsageTimes(3);
        sharedEBike.setTrail("hdihoa");
        sharedEBike.setColor("黄");
        sharedEBike.setBattery(24);
        sharedEBike.setLat(23.3);
        sharedEBike.setLng(112.345);
//        Integer integer = sharedEBikeService.addSharedEBike(sharedEBike);
        boolean save = sharedEBikeService.save(sharedEBike);
        if (save){
            System.out.println("添加成功！！");
        }
    }

    @Test
    void addTest03(){
        SharedBike sharedBike = new SharedBike();
        sharedBike.setNo("tsw2");
        sharedBike.setState("fhid");
        sharedBike.setMonthlyUsageTimes(3);
        sharedBike.setLat(23.35);
        sharedBike.setLng(112.35);
//        Integer integer = sharedBikeService.addSharedBike(sharedBike);
        boolean save = sharedBikeService.save(sharedBike);
        if(save){
            System.out.println("添加成功！！");
        }
    }


    /**
     * 查询测试
     */
    @Test
    void selectAllTest01(){
        List<PersonalEBike> list = personalEBikeService.list();
        for (PersonalEBike i: list) {
            System.out.println(i);
        }
    }

    @Test
    void selectAllTest02(){
        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "正在使用中");
        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
        for (SharedEBike i:list
             ) {
            System.out.println(i);
        }
    }

    @Test
    void selectAllTest03(){
        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "正在使用中").or().eq("state","停车中");
        List<SharedBike> list = sharedBikeService.list(queryWrapper);
        for (SharedBike i:list
             ) {
            System.out.println(i);
        }
    }

    @Test
    void selectbadTest01(){
        QueryWrapper<SharedEBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "维修中");
        List<SharedEBike> list = sharedEBikeService.list(queryWrapper);
        for (SharedEBike i:list
        ) {
            System.out.println(i);
        }
    }

    @Test
    void selectBadTest02(){
        QueryWrapper<SharedBike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "维修中");
        List<SharedBike> list = sharedBikeService.list(queryWrapper);
        for (SharedBike i:list
        ) {
            System.out.println(i);
        }
    }

    /**
     * 删除车辆
     */

    @Test
    void deleteTest01(){
        boolean b = personalEBikeService.removeById(500);
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    void deleteTest02(){
        boolean b = sharedEBikeService.removeById(300);
        if (b){
            System.out.println("删除成功");
        }
    }

    @Test
    void deleteTest03(){
        boolean b = sharedBikeService.removeById(50);
        if (b){
            System.out.println("删除成功");
        }
    }

    /**
     * 更新车辆
     */

    @Test
    void updateTest01(){
        UpdateWrapper<SharedEBike> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("seb_id",301);

        updateWrapper.set("state","test更新");
        boolean b = sharedEBikeService.update(null,updateWrapper);

    }

    @Test
    void updateTest02(){
//        SharedBike sharedBike = new SharedBike();
//        sharedBike.setSbId(51);
////        if(!(state1.equals(state)|| state2.equals(state)|| state3.equals(state))){
////            return "更新失败";
////        }
//        sharedBike.setState("更新test2");
//        boolean b = sharedBikeService.updateById(sharedBike);
//        if(b){
//            System.out.println("更新成功");
//        }

        UpdateWrapper<SharedBike> updateWrapper = new UpdateWrapper<>();

        updateWrapper.eq("sb_id", 51);//作为条件

        updateWrapper.set("state","更新3");//设置想要更新的字段

        boolean b = sharedBikeService.update(null, updateWrapper);//这里的实体类设置为空
    }
}
