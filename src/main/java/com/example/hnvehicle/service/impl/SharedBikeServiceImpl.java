package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.SharedBike;
import com.example.hnvehicle.mapper.SharedBikeMapper;
import com.example.hnvehicle.service.SharedBikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 13:16
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class SharedBikeServiceImpl extends ServiceImpl<SharedBikeMapper, SharedBike> implements SharedBikeService {
    @Autowired
    SharedBikeMapper sharedBikeMapper;

    @Override
    public Integer addSharedBike(SharedBike sharedBike) {
       return sharedBikeMapper.addSharedBike(sharedBike);
    }
}
