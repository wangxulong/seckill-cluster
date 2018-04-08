package com.wang.demo.seckill.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public <T> void send(T msg) {
        log.info("send msg:{}", msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE, msg);
    }
}
