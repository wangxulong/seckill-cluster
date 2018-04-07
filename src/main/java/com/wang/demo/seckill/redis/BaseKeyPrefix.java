package com.wang.demo.seckill.redis;

public abstract class BaseKeyPrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;

    public BaseKeyPrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        //默认0 永远不过期
        return 0;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
