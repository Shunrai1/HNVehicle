package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.PersonalEBike;
import com.example.hnvehicle.mapper.PersonalEBikeMapper;
import com.example.hnvehicle.service.PersonalEBikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:49
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class PersonalEBikeServiceImpl extends ServiceImpl<PersonalEBikeMapper, PersonalEBike> implements PersonalEBikeService {
    @Autowired
    PersonalEBikeMapper personalEBikeMapper;

    @Override
    public Integer addPersonalEBike(PersonalEBike personalEBike) {
        return personalEBikeMapper.addPersonalEBike(personalEBike);
    }
}
