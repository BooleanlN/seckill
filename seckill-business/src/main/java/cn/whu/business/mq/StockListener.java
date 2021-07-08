package cn.whu.business.mq;

import cn.whu.bo.GoodStockBO;
import cn.whu.bo.OrderBO;
import cn.whu.dubbo.good.GoodDubboService;
import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.utils.JsonUtils;
import com.mysql.cj.protocol.MessageListener;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author snow
 * @className StockListener
 * @date 2021/7/6
 **/
@Component
public class StockListener implements MessageListenerConcurrently {
    final static Logger logger = LoggerFactory.getLogger(StockListener.class);
    @Reference
    GoodDubboService goodDubboService;

    /**
     * 消费消息，返回值：
     * CONSUME_SUCCESS：消费成功
     * RECONSUME_LATER：重试
     * @param list
     * @param consumeConcurrentlyContext
     * @return
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        logger.info("消费者线程监听到消息。开始落库存");
        try{
            for (MessageExt message:list) {
                logger.info("开始处理订单数据，准备增加积分....");
                OrderBO order  = JsonUtils.jsonToPojo(new String(message.getBody()), OrderBO.class);
                GoodStockBO goodStockBO = new GoodStockBO();
                goodStockBO.setGoodId(order.getGoodId());
                goodStockBO.setStockCount((long)order.getGoodCount());
                GraceJsonResult jsonResult = goodDubboService.reduceStock(goodStockBO);
                if (!jsonResult.getCode().equals(STATUS.SUCCESS.getCode())){
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}
