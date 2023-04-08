package com.example.hnvehicle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hnvehicle.bean.PersonalEBike;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:45
 * @Version 1.0
 * @Description
 */

@Service
public interface PersonalEBikeService extends IService<PersonalEBike> {
    Integer addPersonalEBike(PersonalEBike personalEBike);
}
