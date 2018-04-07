package com.wang.demo.seckill.redis;

public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
