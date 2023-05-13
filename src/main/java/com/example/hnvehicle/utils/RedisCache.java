package com.example.hnvehicle.utils;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author Shunrai
 * @Date 2023/5/10 14:43
 * @Version 1.0
 * @Description
 */
@Component
public class RedisCache {

    public <T> void cacheDataInRedis(String key,List<T> list) {
        try (Jedis jedis = new Jedis("192.168.149.128", 6379)) {
            // 将 List 集合序列化为 JSON 格式。
            String json = JsonParser.listToJson(list);
            // 将序列化后的 JSON 数据放入 Redis 缓存中。
            jedis.rpush(key, json);
            // 设置 Redis 缓存过期时间，例如 1 小时。
            jedis.expire(key, 3600);
        }catch(Exception e){
            return ;
        }
    }

    public <T> List<T> queryDataFromCache(String key,Class<T> clazz) {
        try (Jedis jedis = new Jedis("192.168.149.128", 6379)) {
            // 从 Redis 缓存中读取 List 数据，并返回反序列化的 List 集合对象。
            List<T> data = JsonParser.jsonToList(jedis.lindex(key,0),clazz);
            return data;
        }catch(Exception e){
            return null;
        }
    }
}
