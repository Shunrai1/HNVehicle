package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author Shunrai
 * @Date 2023/4/7 10:37
 * @Version 1.0
 * @Description
 */
@Data
@Component
@TableName("personal_e_bike")
public class PersonalEBike {
    @TableId(type = IdType.AUTO)
    private Integer pebId;
    private String no;
    private String ownership;
    private String timeInterval;
    private String campus;
    private String color;
    private double lng;
    private double lat;
}
