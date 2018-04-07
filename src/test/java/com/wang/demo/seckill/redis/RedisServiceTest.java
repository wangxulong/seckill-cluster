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
        redisService.set("ddd","123");
    }

    @Test
    public void setEx() throws Exception {
        redisService.setEx("wxl","1",10);
    }

    @Test
    public void get() throws Exception {
        System.out.println(redisService.get("wxl"));
    }

    @Test
    public void expire() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        redisService.delete("ddd");
    }




}