package com.example.hnvehicle;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.mapper.PersonalEBikeMapper;
import com.example.hnvehicle.service.PersonalEBikeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author Shunrai
 * @Date 2023/4/16 23:08
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Resource
    PersonalEBikeService personalEBikeService;
    @Resource
    PersonalEBikeMapper personalEBikeMapper;

    @Test
    public void testPage(){
//        personalEBikeService.pageMaps();
        Page<PersonalEBike> personalEBikePage = new Page<>(1,10);
        Page<PersonalEBike> page = personalEBikeMapper.selectPage(personalEBikePage, null);
        System.out.println(page);
    }
}
