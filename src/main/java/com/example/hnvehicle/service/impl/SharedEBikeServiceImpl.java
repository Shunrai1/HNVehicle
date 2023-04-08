package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.SharedEBike;
import com.example.hnvehicle.mapper.SharedEBikeMapper;
import com.example.hnvehicle.service.SharedEBikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 13:18
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class SharedEBikeServiceImpl extends ServiceImpl<SharedEBikeMapper, SharedEBike> implements SharedEBikeService {
    @Autowired
    SharedEBikeMapper sharedEBikeMapper;

    @Override
    public Integer addSharedEBike(SharedEBike sharedEBike) {
      return  sharedEBikeMapper.addSharedEBike(sharedEBike);
    }
}
