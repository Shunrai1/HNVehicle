package com.example.hnvehicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hnvehicle.bean.UsageRate;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Shunrai
 * @Date 2023/5/9 14:49
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UsageRateMapper extends BaseMapper<UsageRate> {
    double getRate(Integer month);
}
