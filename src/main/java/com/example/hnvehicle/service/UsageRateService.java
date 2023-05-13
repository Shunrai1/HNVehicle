package com.example.hnvehicle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hnvehicle.bean.UsageRate;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/5/9 14:51
 * @Version 1.0
 * @Description
 */
@Service
public interface UsageRateService extends IService<UsageRate> {
    double getRate(Integer month);
}
