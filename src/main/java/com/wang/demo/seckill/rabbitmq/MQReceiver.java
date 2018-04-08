package com.wang.demo.seckill.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void receive(String message) {
        System.out.println(message);
        log.info("receive msg:{}", message);
    }
}
