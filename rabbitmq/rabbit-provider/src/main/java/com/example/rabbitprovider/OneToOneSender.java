package com.example.rabbitprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author wy
 * @Description 发送者
 * @createTime 2020/02/13
 */
@Component
@Slf4j
public class OneToOneSender {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "OneToOne" + LocalDateTime.now().toString();
        log.info("OneToOne==={}", content);
        amqpTemplate.convertAndSend("OneToOne", content);
    }
}
