package com.example.hnvehicle.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @Author Shunrai
 * @Date 2023/4/7 11:19
 * @Version 1.0
 * @Description
 */
@Data
@Component
@TableName("stops")
public class Stop {
    @TableId(type = IdType.AUTO)
    private Integer sId;
    private String locality;
}
