package com.wang.demo.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    @Autowired
    private Jedis jedis;

    public void set(String key,String value){
        jedis.set(key,value);
    }

    public void setEx(String key,String value,int expire){
        jedis.setex(key,expire,value);
    }

    public String get(String key){
        return jedis.get(key);
    }

    public void expire(String key,int expire){
        jedis.expire(key,expire);
    }

    public void delete(String... keys){
        jedis.del(keys);
    }


}
