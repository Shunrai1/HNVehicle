package com.example.hnvehicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hnvehicle.bean.SharedBike;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Shunrai
 * @Date 2023/4/7 13:14
 * @Version 1.0
 * @Description
 */
@Mapper
public interface SharedBikeMapper extends BaseMapper<SharedBike> {
    Integer addSharedBike(SharedBike sharedBike);
}
