package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.Stop;
import com.example.hnvehicle.mapper.StopMapper;
import com.example.hnvehicle.service.StopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/24 13:58
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class StopServiceImpl extends ServiceImpl<StopMapper, Stop> implements StopService {
}
