package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author Shunrai
 * @Date 2023/4/7 11:16
 * @Version 1.0
 * @Description
 */
@Data
@Component
@TableName("shared_bike")
public class SharedBike {
    @TableId(type = IdType.AUTO)
    private Integer sbId;
    private String no;
    private String state;
    private int monthlyUsageTimes;
    private double lng;
    private double lat;
}
