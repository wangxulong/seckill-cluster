package com.wang.demo.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisPoolConfig {
    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(redisConfig.getMaxActive());
        config.setMaxIdle(redisConfig.getMaxIdle());
        config.setMaxWaitMillis(redisConfig.getMaxWait() * 1000);
        config.setTestOnBorrow(redisConfig.isTestOnBorrow());
        config.setTestOnReturn(redisConfig.isTestOnReturn());
        return new JedisPool(config, redisConfig.getHost(),
                redisConfig.getPort(), 1000 * 2);
    }

    @Bean
    public Jedis jedis() {
        return jedisPool().getResource();
    }
}
