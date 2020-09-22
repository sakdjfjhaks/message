package com.practice.message.rabbitmq.receiver.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Component
public class TopicManReceiver {

    @RabbitListener(
            bindings =
            @QueueBinding(
                    value = @Queue("maoqudiaoyu.customer.add"),
                    exchange = @Exchange(value = "maoqudiaoyu.capi"),
                    key = "maoqudiaoyu.customer.add"
            )
    )
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }
}
