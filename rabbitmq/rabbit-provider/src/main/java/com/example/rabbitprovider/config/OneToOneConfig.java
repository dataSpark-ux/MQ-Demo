package com.example.rabbitprovider.config;

import com.rabbit.common.Constant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wy
 * @Description Direct
 * 就是一对一模式，从上面可以知道，RabbitMQ有发送者，交换机，队列，接收者。
 * Direct就是一个发送者对应一个接收者。如果有多个，只会有一个接收到消息。
 * @createTime 2020/02/13
 */
@Configuration
public class OneToOneConfig {

    @Bean
    public Queue oneQueue() {
        return new Queue(Constant.ONE_TWO_ONE);
    }

}
