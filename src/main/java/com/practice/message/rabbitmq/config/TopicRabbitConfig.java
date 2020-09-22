package com.practice.message.rabbitmq.config;

import com.practice.message.rabbitmq.constant.RabbitMqExchangeConstant;
import com.practice.message.rabbitmq.constant.RabbitMqKeyConstant;
import com.practice.message.rabbitmq.constant.RabbitMqQueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/

@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue firstQueue() {
        return new Queue(RabbitMqQueueConstant.FIRST_TOPIC_QUEUE_CONSTANT);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(RabbitMqQueueConstant.SECOND_TOPIC_QUEUE_CONSTANT);
    }

    @Bean
    public Queue thirdQueue() {
        return new Queue(RabbitMqQueueConstant.THIRD_TOPIC_QUEUE_CONSTANT);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange(RabbitMqExchangeConstant.TOPIC_EXCHANGE_CONSTANT);
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(RabbitMqKeyConstant.FIRST_TOPIC_KEY_CONSTANT);
    }
    @Bean
    Binding bindingExchangeMessage1() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with(RabbitMqKeyConstant.SECOND_TOPIC_KEY_CONSTANT);
    }

    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(thirdQueue()).to(exchange()).with(RabbitMqKeyConstant.THIRD_TOPIC_KEY_CONSTANT);
    }


}
