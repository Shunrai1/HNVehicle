package com.example.hnvehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hnvehicle.bean.ChargingPile;
import com.example.hnvehicle.mapper.ChargingPileMapper;
import com.example.hnvehicle.service.ChargingPileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Shunrai
 * @Date 2023/4/24 14:05
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class ChargingPileServiceImpl extends ServiceImpl<ChargingPileMapper, ChargingPile> implements ChargingPileService {
}
