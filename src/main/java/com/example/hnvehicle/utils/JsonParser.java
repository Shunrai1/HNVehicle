package com.example.hnvehicle.utils;

import com.alibaba.fastjson2.JSON;

import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/5/10 15:02
 * @Version 1.0
 * @Description
 */
public class JsonParser {
    public static <T> String listToJson(List<T> data) {
        return JSON.toJSONString(data);
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }
}
