package com.zb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key , String value){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public void set(String key , String value,int time){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value,time, TimeUnit.SECONDS);
    }

    public String get(String key){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public boolean exists(String key){
        if(this.get(key)!=null){
            return true;
        }else{
            return false;
        }
    }



}
