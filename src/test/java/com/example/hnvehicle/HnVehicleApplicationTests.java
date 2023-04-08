package com.example.hnvehicle;

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
        personalEBike.setLat(23.3455234);
        personalEBike.setLng(112.35533);
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

}
