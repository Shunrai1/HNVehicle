package com.example.hnvehicle.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.service.PersonalEBikeService;
import com.example.hnvehicle.service.SharedBikeService;
import com.example.hnvehicle.service.SharedEBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/4/17 10:53
 * @Version 1.0
 * @Description 实现个人电动车，共享电动车，共享单车的分页功能
 */
@Controller
public class PaginationController {
    @Resource
    PersonalEBikeService personalEBikeService;
    @Resource
    SharedEBikeService sharedEBikeService;
    @Resource
    SharedBikeService sharedBikeService;

    final static int PAGE_SIZE = 10;

    /**
     * 判断当前个人电动车页码是否有前一页
     *
     * @param current 当前页码
     * @return
     */
    @RequestMapping("/personalEBike/hasPrevious")
    @ResponseBody
    public boolean hasPrevious(String current) {
        Page<PersonalEBike> personalEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<PersonalEBike> page = personalEBikeService.page(personalEBikePage);
        return page.hasPrevious();
    }

    @RequestMapping("/personalEBike/hasNext")
    @ResponseBody
    public boolean hasNext(String current){
        Page<PersonalEBike> personalEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<PersonalEBike> page = personalEBikeService.page(personalEBikePage);
        return page.hasNext();
    }

    @RequestMapping("/personalEBike/pageRecords")
    @ResponseBody
    public List<PersonalEBike> pageRecords(String current){
        Page<PersonalEBike> personalEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<PersonalEBike> page = personalEBikeService.page(personalEBikePage);
        return page.getRecords();
    }

    @RequestMapping("/personalEBike/pages")
    @ResponseBody
    public Long Pages(String current){
        Page<PersonalEBike> personalEBikePage = new Page<>(Integer.parseInt(current),PAGE_SIZE);
        Page<PersonalEBike> page = personalEBikeService.page(personalEBikePage);
        return page.getPages();
    }


    /**
     * 判断当前共享电动车页码是否有前一页
     *
     * @param current 当前页码
     * @return
     */
    @RequestMapping("/sharedEBike/hasPrevious")
    @ResponseBody
    public boolean hasPrevious02(String current) {
        Page<SharedEBike> sharedEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedEBike> page = sharedEBikeService.page(sharedEBikePage);
        return page.hasPrevious();
    }

    @RequestMapping("/sharedEBike/hasNext")
    @ResponseBody
    public boolean hasNext02(String current){
        Page<SharedEBike> sharedEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedEBike> page = sharedEBikeService.page(sharedEBikePage);
        return page.hasNext();
    }

    @RequestMapping("/sharedEBike/pageRecords")
    @ResponseBody
    public List<SharedEBike> pageRecords02(String current){
        Page<SharedEBike> sharedEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedEBike> page = sharedEBikeService.page(sharedEBikePage);
        return page.getRecords();
    }

    @RequestMapping("/sharedEBike/pages")
    @ResponseBody
    public Long Pages02(String current){
        Page<SharedEBike> sharedEBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedEBike> page = sharedEBikeService.page(sharedEBikePage);
        return page.getPages();
    }

    /**
     * 判断当前共享单车页码是否有前一页
     *
     * @param current 当前页码
     * @return
     */
    @RequestMapping("/sharedBike/hasPrevious")
    @ResponseBody
    public boolean hasPrevious03(String current) {
        Page<SharedBike> sharedBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedBike> page = sharedBikeService.page(sharedBikePage);
        return page.hasPrevious();
    }

    @RequestMapping("/sharedBike/hasNext")
    @ResponseBody
    public boolean hasNext03(String current){
        Page<SharedBike> sharedBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedBike> page = sharedBikeService.page(sharedBikePage);
        return page.hasNext();
    }

    @RequestMapping("/sharedBike/pageRecords")
    @ResponseBody
    public List<SharedBike> pageRecords03(String current){
        Page<SharedBike> sharedBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedBike> page = sharedBikeService.page(sharedBikePage);
        return page.getRecords();
    }

    @RequestMapping("/sharedBike/pages")
    @ResponseBody
    public Long Pages03(String current){
        Page<SharedBike> sharedBikePage = new Page<>(Integer.parseInt(current), PAGE_SIZE);
        Page<SharedBike> page = sharedBikeService.page(sharedBikePage);
        return page.getPages();
    }
}
