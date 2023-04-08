package com.example.hnvehicle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hnvehicle.bean.SharedEBike;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:46
 * @Version 1.0
 * @Description
 */
@Service
public interface SharedEBikeService extends IService<SharedEBike> {
    Integer addSharedEBike(SharedEBike sharedEBike);
}
