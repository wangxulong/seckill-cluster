package com.wang.demo.seckill.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {
    public static final String QUEUE = "queue";

    /**
     * redirect模式
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(MQConfig.QUEUE, true);
    }


}
