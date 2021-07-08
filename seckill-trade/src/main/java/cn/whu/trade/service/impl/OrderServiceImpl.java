package cn.whu.trade.service.impl;

import cn.whu.bo.OrderBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.pojo.TTrade;
import cn.whu.pojo.TTradeLog;
import cn.whu.service.BaseService;
import cn.whu.trade.mapper.TTradeLogMapper;
import cn.whu.trade.mapper.TTradeMapper;
import cn.whu.trade.service.OrderService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author snow
 * @className OrderServiceImpl
 * @date 2021/6/29
 **/
@Service
public class OrderServiceImpl extends BaseService implements OrderService {

    @Resource
    Sid sid;

    @Resource
    TTradeMapper tradeMapper;

    @Resource
    TTradeLogMapper logMapper;
    /**
     * 创建订单
     *
     * @param orderBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(OrderBO orderBO, String transactionId) {
        // 1.缓存减库存
        String storageKey = REDIS_STORAGE_COUNT + ":" + orderBO.getGoodId();
        long result = redis.decrement(storageKey,orderBO.getGoodCount());
        if (result < 0){
            redis.increment(storageKey,orderBO.getGoodCount());
            GraceException.display(STATUS.UPDATE_STORAGE_FAIL);
        }
        // 创建订单
        TTrade trade = new TTrade();

        String tradeId = sid.nextShort();
        trade.setTradeId(tradeId);
        BeanUtils.copyProperties(orderBO, trade);

        if (trade.getActivityId()==null){
            trade.setActivityId(COMMON_ACTIVITY);
        }
        trade.setCreateTime(new Date());
        trade.setUpdateTime(new Date());

        
        int res = tradeMapper.insert(trade);
        if (res != 1){
            GraceException.display(STATUS.ORDER_CREATE_FAIL);
        }

        TTradeLog tTradeLog = new TTradeLog();
        tTradeLog.setLogId(sid.nextShort());
        tTradeLog.setOrderId(orderBO.getTradeId());
        tTradeLog.setTransactionId(transactionId);
        tTradeLog.setUserId(orderBO.getUserId());
        tTradeLog.setCreateTime(new Date());
        tTradeLog.setUpdateTime(new Date());

        res = logMapper.insert(tTradeLog);
        if (res != 1){
            GraceException.display(STATUS.ORDER_CREATE_FAIL);
        }
    }
}
