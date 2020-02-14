package com.example.rabbitprovider;

import com.rabbit.common.Constant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author wy
 * @Description
 * @createTime 2020/02/14
 */
@Component
public class FanoutSender {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void fanSender1() {
        String message = "FanSender1111:" + LocalDateTime.now().toString();
        this.amqpTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, "", message);
    }

    public void fanSender2() {
        String message = "FanSender222:" + LocalDateTime.now().toString();
        this.amqpTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, "", message);
    }


}
