package com.wang.demo.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    @Autowired
    private Jedis jedis;

    public void set(){
        jedis.set("wxl","123");
    }


}
