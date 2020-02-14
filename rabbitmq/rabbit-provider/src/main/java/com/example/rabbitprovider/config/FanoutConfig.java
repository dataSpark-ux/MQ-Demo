package com.example.rabbitprovider.config;

import com.rabbit.common.Constant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wy
 * @Description Fanout模式就是发布订阅模式，发布者发布了消息时候顺便绑定交换器，
 * 交换器又是跟队列绑定的，那么跟这个交换器绑定的所有队列都会收到这个消息，
 * 相应的绑定了这些队列的所有接收者都会接收到发送的消息。
 * @createTime 2020/02/14
 */
@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutA() {
        return new Queue(Constant.FANOUT_A);
    }

    @Bean
    public Queue fanoutB() {
        return new Queue(Constant.FANOUT_B);
    }
    /**
    *交换器
    */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constant.FANOUT_EXCHANGE);
    }
    /**
    *绑定队列与交换器的关系
    */
    @Bean
    Binding bindingFanoutA() {
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }


    @Bean
    Binding bindingFanoutB() {
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }
}
