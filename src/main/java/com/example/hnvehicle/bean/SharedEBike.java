package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author Shunrai
 * @Date 2023/4/7 11:11
 * @Version 1.0
 * @Description
 */
@Data
@Component
@TableName("shared_e_bike")
public class SharedEBike {
    @TableId(type = IdType.AUTO)
    private Integer sebId;
    private String no;
    private String state;
    private String cumlativeUsageTime;
    private int monthlyUsageTimes;
    private String trail;
    private String color;
    private int battery;
    private double lng;
    private double lat;
}
