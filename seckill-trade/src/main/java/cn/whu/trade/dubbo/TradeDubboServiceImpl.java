package cn.whu.trade.dubbo;

import cn.whu.bo.NewOrderBO;
import cn.whu.bo.OrderBO;
import cn.whu.dubbo.trade.TradeDubboService;
import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TTradeLog;
import cn.whu.trade.service.LogService;
import cn.whu.trade.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author snow
 * @className TradeDubboServiceImpl
 * @date 2021/7/4
 **/
@Service
public class TradeDubboServiceImpl implements TradeDubboService {
    final static Logger logger = LoggerFactory.getLogger(TradeDubboServiceImpl.class);

    @Resource
    OrderService orderService;

    @Resource
    LogService logService;
    /**
     * 创建新订单
     *
     * @param orderBO
     * @return
     */
    @Override
    public GraceJsonResult createTrade(OrderBO orderBO,  String transactionId) {
        orderService.createOrder(orderBO, transactionId);
        logger.info("订单创建成功");
        return GraceJsonResult.ok(orderBO);
    }

    /**
     * 查询交易流水
     *
     * @param transactionId
     * @return
     */
    @Override
    public GraceJsonResult queryTradeLog(String transactionId) {
        TTradeLog log = logService.queryLogByTransactionId(transactionId);
        if (log == null){
            return GraceJsonResult.errorCustom(STATUS.NOT_FOUND_TRADE_LOG);
        }
        return GraceJsonResult.ok();
    }
}
