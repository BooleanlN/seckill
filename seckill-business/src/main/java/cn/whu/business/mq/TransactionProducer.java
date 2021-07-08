package cn.whu.business.mq;

import io.lettuce.core.TransactionResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author snow
 * @className TransactionProducer
 * @date 2021/7/5
 **/
@Component
public class TransactionProducer {
    private String producerGroup = "order_group";
    private TransactionMQProducer producer;

    @Value("${rocketmq.name-server}")
    private String nameSvrAddr;

    @Resource
    TransactionListener transactionListener;

    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(50),Executors.defaultThreadFactory());
    @PostConstruct
    public void init(){
        producer = new TransactionMQProducer(producerGroup);
        producer.setNamesrvAddr(nameSvrAddr);
        producer.setSendMsgTimeout(Integer.MAX_VALUE);
        producer.setExecutorService(executor);
        producer.setTransactionListener(transactionListener);
        this.start();
    }
    private void start(){
        try{
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    public TransactionSendResult send(String topic, String data, Map<String,Object> args) throws MQClientException {
        Message message = new Message(topic, data.getBytes());
        return this.producer.sendMessageInTransaction(message, args);
    }
}
