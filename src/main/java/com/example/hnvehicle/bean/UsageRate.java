package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author Shunrai
 * @Date 2023/5/9 14:44
 * @Version 1.0
 * @Description
 */
@Component
@Data
@TableName("usage_rate")
public class UsageRate {
    private Integer usId;
    private Integer month;
    private Integer totalUsage;
    private Integer day;

}
