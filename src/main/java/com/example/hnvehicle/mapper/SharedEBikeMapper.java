package com.example.hnvehicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hnvehicle.bean.SharedEBike;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Shunrai
 * @Date 2023/4/7 13:15
 * @Version 1.0
 * @Description
 */
@Mapper
public interface SharedEBikeMapper extends BaseMapper<SharedEBike> {
    Integer addSharedEBike(SharedEBike sharedEBike);
}
