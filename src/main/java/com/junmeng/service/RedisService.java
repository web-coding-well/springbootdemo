package com.junmeng.service;

import com.junmeng.bean.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by HWJ on 2017/4/3.
 */
@Service
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    public  Girl getGirl(String key) {
        return (Girl)redisTemplate.opsForValue().get(key);
    }

    public void setGirl(String key,Girl value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key){
       return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *
     * @param key
     * @param value
     * @param expired 有效期 毫秒
     */
    public void set(String key,String value,int expired){
         stringRedisTemplate.opsForValue().set(key,value);
        stringRedisTemplate.expire(key,expired, TimeUnit.MILLISECONDS);
    }
}
