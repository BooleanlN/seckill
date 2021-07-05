package cn.whu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author snow
 * @className RedisOperator
 * @date 2021/6/27
 **/
@Component
public class RedisOperator {
    @Autowired
    private StringRedisTemplate redisTemplate;


    public boolean isKeyExist(String key){
        return redisTemplate.hasKey(key);
    }

    public void set(String key,String val){
        redisTemplate.opsForValue().set(key, val);
    }


    public void set(String key,String val,long ttl){
        redisTemplate.opsForValue().set(key, val, ttl);
    }


    public String getKey(String key){
        return redisTemplate.opsForValue().get(key);
    }


    public long ttl(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }


    public void setKeyIfNotExist(String key,String val){
        redisTemplate.opsForValue().setIfAbsent(key, val);
    }


    public void increment(String key){
        redisTemplate.opsForValue().increment(key);
    }

    public long increment(String key, Long amount){
        return redisTemplate.opsForValue().increment(key, amount);
    }

    public void decrement(String key){
        redisTemplate.opsForValue().decrement(key);
    }

    public long decrement(String key, Long amount){
        return redisTemplate.opsForValue().decrement(key, amount);
    }

    public void delKey(String key){
        redisTemplate.delete(key);
    }


    public void setnx60s(String key, String value) {
        redisTemplate.opsForValue().setIfAbsent(key, value, 60, TimeUnit.SECONDS);
    }


    //=========hash==============
    public void hset(String key,String field,Object value){
        redisTemplate.opsForHash().put(key,field,value);
    }


    public Object hget(String key,String field){
        return redisTemplate.opsForHash().get(key, field);
    }


    public void hdel(String key,Object... fields){
        redisTemplate.opsForHash().delete(key,fields);
    }


    public Map<Object,Object> hgetAll(String key){
        return redisTemplate.opsForHash().entries(key);
    }


    //===========List================
    public long lpush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }


    public String lpop(String key) {
        return (String)redisTemplate.opsForList().leftPop(key);
    }


    public long rpush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }
}
