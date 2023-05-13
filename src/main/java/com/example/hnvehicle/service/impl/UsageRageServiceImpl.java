package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.Stop;
import com.example.hnvehicle.bean.UsageRate;
import com.example.hnvehicle.mapper.StopMapper;
import com.example.hnvehicle.mapper.UsageRateMapper;
import com.example.hnvehicle.service.UsageRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Shunrai
 * @Date 2023/5/9 14:52
 * @Version 1.0
 * @Description
 */
@Service
@Slf4j
public class UsageRageServiceImpl extends ServiceImpl<UsageRateMapper, UsageRate> implements UsageRateService {
    @Resource
    private UsageRateMapper usageRateMapper;

    @Override
    public double getRate(Integer month) {
        return usageRateMapper.getRate(month);

    }


}
