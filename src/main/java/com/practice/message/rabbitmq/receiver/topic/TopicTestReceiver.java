package com.practice.message.rabbitmq.receiver.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "test.man")
public class TopicTestReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicTestReceiver消费者收到消息  : " + testMessage.toString());
    }
}
