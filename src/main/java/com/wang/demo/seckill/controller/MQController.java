package com.wang.demo.seckill.controller;

import com.wang.demo.seckill.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mq")
public class MQController {

    @Autowired
    MQSender mqSender;
    @GetMapping("queue/send")
    public String queueSend(String msg){
        mqSender.send(msg);
        return msg;
    }
}
