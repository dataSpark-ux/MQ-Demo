package com.example.rabbitprovider;

import com.rabbit.common.Constant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author wy
 * @Description topic发送者
 * 发送者发送消息时，传的三个参数，
 * 第一个时你要传给的交换机，
 * 第二个是传给交换机的条件，在Topic模式中，队列与交换机会有一个匹配的条件，如果现在有三个队列和交换机绑定，
 * 分别条件是：A: topic.# ,B: topic.msg, C:topic.*.z（#代表多个，*代表一个）。
 * @createTime 2020/02/14
 */
@Component
public class TopicSender {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendA() {
        String msg = "[topic.msg] Send1 msg " + LocalDateTime.now().toString();
        amqpTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, "topic.msg", msg);
    }

    public void sendB() {
        String msg = "[topic.good.msg] Send2 msg:" + LocalDateTime.now().toString();
        amqpTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, "topic.good.msg", msg);
    }

    public void sendC() {
        String msg = "[topic.m.z] Send3 msg:" + LocalDateTime.now().toString();
        amqpTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, "topic.m.z", msg);
    }

    public void sendD() {
        String msg = "[topic.d.z] Send3 msg:" + LocalDateTime.now().toString();
        amqpTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, "topic.d.z", msg);
    }
}
