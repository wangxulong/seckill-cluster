package com.wang.demo.seckill.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void set() throws Exception {
        redisService.set();
    }

}