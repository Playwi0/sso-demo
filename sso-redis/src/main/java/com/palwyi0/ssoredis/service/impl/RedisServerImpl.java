package com.palwyi0.ssoredis.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.playwi0.ssoapi.common.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */

@Service
@Component
public class RedisServerImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean setex(String key, long second, Object value){

        try {
            redisTemplate.opsForValue().set(key, value, second, TimeUnit.SECONDS);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
