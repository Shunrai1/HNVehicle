package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * @Author Shunrai
 * @Date 2023/4/7 11:18
 * @Version 1.0
 * @Description
 */
@Data
@Component
@TableName("charging_pile")
public class ChargingPile {
    @TableId(type = IdType.AUTO)
    private Integer cpId;
    private String locality;
    private String state;
}
