package com.example.hnvehicle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hnvehicle.bean.SharedBike;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:47
 * @Version 1.0
 * @Description
 */
@Service
public interface SharedBikeService extends IService<SharedBike> {
    Integer addSharedBike(SharedBike sharedBike);
}
