package com.example.rabbitmqconsumer;

import com.rabbit.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wy
 * @Description
 * @createTime 2020/02/13
 */
@Component
@RabbitListener(queues = Constant.ONE_TWO_ONE)
@Slf4j
public class OneToOneReceiver {

    @RabbitHandler
    public void receiver(String context) {
        log.info("收到消息，{}", context);
    }
}
