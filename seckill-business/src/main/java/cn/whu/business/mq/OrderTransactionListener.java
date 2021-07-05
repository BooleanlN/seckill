package cn.whu.business.mq;

import cn.whu.bo.OrderBO;
import cn.whu.dubbo.trade.TradeDubboService;
import cn.whu.dubbo.user.UserDubboService;
import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.utils.JsonUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author snow
 * @className OrderTransactionListener
 * @date 2021/7/5
 **/
@Component
public class OrderTransactionListener implements TransactionListener {
    final static Logger logger = LoggerFactory.getLogger(OrderTransactionListener.class);

    @Reference
    TradeDubboService tradeDubboService;
    /**
     * 这里添加本地事务逻辑，返回本地事务的执行状态：
     * COMMIT_MESSAGE（提交消息，消费者会看到）、
     * ROLLBACK_MESSAGE（回滚消息，消费者不会看到）、
     * UNKNOW（事务未知状态，需要调用事务状态回查，确定此消息是提交还是回滚）
     * @param message
     * @param o
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        logger.info("开始执行本地事务..." + message.getProperty("orderId"));
        LocalTransactionState state = null;
        try {
            String body = new String(message.getBody());
            OrderBO orderBO = JsonUtils.jsonToPojo(body, OrderBO.class);
            GraceJsonResult jsonResult = tradeDubboService.createTrade(orderBO,message.getTransactionId());
            if (jsonResult.getCode().equals(STATUS.SUCCESS.getCode())){
                state = LocalTransactionState.COMMIT_MESSAGE;
                logger.info("本地事务已提交。{}",message.getTransactionId());
            } else {
                state = LocalTransactionState.ROLLBACK_MESSAGE;
                logger.info("本地事务执行失败。{}",message.getTransactionId());
            }
        } catch (Exception e){
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    /**
     * 以1分钟间隔，回查本地事务执行状态，直至达到事务回查最大检测数，如果超过这个数字还未查询到事务状态，则回滚此消息。
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        logger.info("开始回查本地事务状态。{}",messageExt.getTransactionId());
        LocalTransactionState state;
        GraceJsonResult jsonResult = tradeDubboService.queryTradeLog(messageExt.getTransactionId());
        if (jsonResult.getCode().equals(STATUS.SUCCESS.getCode())){
            state = LocalTransactionState.COMMIT_MESSAGE;
        } else {
            state = LocalTransactionState.UNKNOW;
        }
        logger.info("结束本地事务状态查询：{}",state);
        return state;
    }
}
