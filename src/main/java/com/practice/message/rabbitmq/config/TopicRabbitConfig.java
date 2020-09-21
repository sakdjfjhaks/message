package com.practice.message.rabbitmq.config;

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
    //绑定键
    public final static String test = "test.man";
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    @Bean
    public Queue testQueue() {
        return new Queue(TopicRabbitConfig.test);
    }
    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.man);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(testQueue()).to(exchange()).with("*.man");
    }
    @Bean
    Binding bindingExchangeMessage1() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with("topic.#");
    }


}
