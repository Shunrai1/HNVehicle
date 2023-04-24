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

    /**
     * 使用BaseMapper 来调用分页功能
     */
    @Test
    public void testPage(){
//        personalEBikeService.pageMaps();
        //current: 当前页  size：每页多少条
        Page<PersonalEBike> personalEBikePage = new Page<>(1,10);
        Page<PersonalEBike> page = personalEBikeMapper.selectPage(personalEBikePage, null);
        System.out.println(page);
        System.out.println(page.getRecords());//获取当前页的数据
        System.out.println(page.getCurrent());//获取当前业码
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.hasPrevious());//是否有上一页
        System.out.println(page.hasNext());//是否有下一页
    }

    /**
     * 自定义分页功能
     */
    @Test
    public void testPageVo(){
        Page<PersonalEBike> page = new Page<>(1,4);
        Page<PersonalEBike> pageVo = personalEBikeMapper.selectPageVo(page, "启林北");

    }

    /**
     * 使用IService 来调用page分页功能
     */
    @Test
    public void testPage2(){
        Page<PersonalEBike> personalEBikePage = new Page<>(1,10);
        Page<PersonalEBike> page = personalEBikeService.page(personalEBikePage);
        System.out.println(page);
        System.out.println(page.getRecords());//获取当前页的数据
        System.out.println(page.getCurrent());//获取当前业码
        System.out.println(page.getPages());//总页数
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.hasPrevious());//是否有上一页
        System.out.println(page.hasNext());//是否有下一页
    }
}
