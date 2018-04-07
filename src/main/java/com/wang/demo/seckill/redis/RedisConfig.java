package com.wang.demo.seckill.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String host;
    private int port;
    private String password;
    private int maxIdle;
    private int maxActive;
    private int maxWait;
    private boolean testOnBorrow;
    private int timeout;
    private boolean testOnReturn;
}
