package com.wang.demo.seckill.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MQSenderTest {
    @Autowired
    private MQSender mqSender;
    @Test
    public void send() throws Exception {
        mqSender.send("王旭龙");
    }

}