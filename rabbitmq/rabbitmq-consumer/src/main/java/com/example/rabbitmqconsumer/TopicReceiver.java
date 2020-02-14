package com.example.rabbitmqconsumer;

import com.rabbit.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wy
 * @Description
 * @createTime 2020/02/14
 */
@Component
@Slf4j
public class TopicReceiver {

    @RabbitHandler
    @RabbitListener(queues = Constant.TOPIC_A)
    public void receiverA(String message) {
        log.info(Constant.TOPIC_A + "收到消息==>>{}", message);
    }

    @RabbitHandler
    @RabbitListener(queues = Constant.TOPIC_B)
    public void receiverB(String message) {
        log.info(Constant.TOPIC_B + "收到消息==>>{}", message);
    }

    @RabbitHandler
    @RabbitListener(queues = Constant.TOPIC_C)
    public void receiverC(String message) {
        log.info(Constant.TOPIC_C + "收到消息===>>{}", message);
    }
}
