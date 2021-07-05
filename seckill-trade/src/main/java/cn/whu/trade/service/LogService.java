package cn.whu.trade.service;

import cn.whu.pojo.TTradeLog;

/**
 * @author snow
 * @className LogService
 * @date 2021/7/5
 **/
public interface LogService {
    /**
     * 根据事务ID查询流水
     * @param transactionId
     * @return
     */
    TTradeLog queryLogByTransactionId(String transactionId);
}
