package com.example.rabbitprovider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitProviderApplicationTests {
    @Resource
    OneToOneSender oneToOneSender;
    @Test
    void contextLoads() {
    }

    @Test
    void OneToOne() {
        oneToOneSender.send();
    }

}
