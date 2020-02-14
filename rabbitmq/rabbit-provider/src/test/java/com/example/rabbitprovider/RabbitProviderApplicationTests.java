package com.example.rabbitprovider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitProviderApplicationTests {
    @Resource
    OneToOneSender oneToOneSender;
    @Resource
    FanoutSender fanoutSender;
    @Resource
    TopicSender topicSender;
    @Test
    void contextLoads() {
    }

    @Test
    void OneToOne() {
        oneToOneSender.send();
    }

    @Test
    void fanout() {
        fanoutSender.fanSender1();
        fanoutSender.fanSender2();
    }

    @Test
    void topic() {
        topicSender.sendA();
        topicSender.sendB();
        topicSender.sendC();
        topicSender.sendD();
    }

}
