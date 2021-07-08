package cn.whu.business.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author snow
 * @className MqConsumer
 * @date 2021/7/6
 **/
@Component
public class MqConsumer {
    private String consumerGroup = "stock";
    DefaultMQPushConsumer consumer;

    @Value("${rocketmq.name-server}")
    private String nameSvrAddr;
    @Resource
    StockListener stockListener;
    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(nameSvrAddr);
        consumer.subscribe("order", "*");
        consumer.registerMessageListener(stockListener);
        consumer.start();
    }

}
