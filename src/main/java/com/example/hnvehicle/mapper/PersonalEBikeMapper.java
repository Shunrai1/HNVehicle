package com.example.hnvehicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hnvehicle.bean.PersonalEBike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.springframework.stereotype.Repository;

/**
 * @Author Shunrai
 * @Date 2023/4/7 12:54
 * @Version 1.0
 * @Description
 */
@Mapper
public interface PersonalEBikeMapper extends BaseMapper<PersonalEBike> {
    Integer addPersonalEBike(PersonalEBike personalEBike);
}
