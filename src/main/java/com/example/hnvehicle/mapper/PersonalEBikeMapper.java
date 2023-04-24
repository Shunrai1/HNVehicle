package com.example.hnvehicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hnvehicle.bean.PersonalEBike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 自定义分页
     * @param page MyBatisPlus提供的分页对象，必须位于第一个位置
     * @param campus
     * @return
     */
    Page<PersonalEBike> selectPageVo(@Param("page") Page<PersonalEBike>page, @Param("campus") String campus);
}
