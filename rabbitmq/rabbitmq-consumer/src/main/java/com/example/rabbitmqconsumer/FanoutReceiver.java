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
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = Constant.FANOUT_A)
    public void fanoutReceiver1(String message) {
        log.info("fanoutA收到消息===>>{}", message);
    }

    @RabbitHandler
    @RabbitListener(queues = Constant.FANOUT_B)
    public void fanoutReceiver2(String message) {
        log.info("fanoutB接收到消息===>>{}", message);
    }

}
