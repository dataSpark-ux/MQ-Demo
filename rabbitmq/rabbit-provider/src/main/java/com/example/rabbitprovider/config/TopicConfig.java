package com.example.rabbitprovider.config;

import com.rabbit.common.Constant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author wy
 * @Description Topic模式就相当于发布订阅模式交换机和队列之间加上了一定的匹配规则。
 * 只有符合规则的消息才能到这个队列中去从而被接收者收到。看代码
 * @createTime 2020/02/14
 */
@Configuration
public class TopicConfig {

    @Bean
    public Queue topicQueueA() {
        return new Queue(Constant.TOPIC_A);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(Constant.TOPIC_B);
    }

    @Bean
    public Queue topicQueueC() {
        return new Queue(Constant.TOPIC_C);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(Constant.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with("topic.msg");
    }


    @Bean
    public Binding bindingB() {
        //#表示0个或者多个
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding bindingC() {
        //*代表一个
        return BindingBuilder.bind(topicQueueC()).to(topicExchange()).with("topic.*.z");
    }
}
