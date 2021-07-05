package cn.whu.dubbo.trade;

import cn.whu.bo.OrderBO;
import cn.whu.grace.result.GraceJsonResult;

/**
 * @author snow
 * @className TradeDubboService
 * @date 2021/7/4
 **/
public interface TradeDubboService {
    /**
     * 创建新订单
     * @param orderBO
     * @param transactionId
     * @return
     */
    public GraceJsonResult createTrade(OrderBO orderBO, String transactionId);

    /**
     * 查询交易流水
     * @param transactionId
     * @return
     */
    public GraceJsonResult queryTradeLog(String transactionId);
}
