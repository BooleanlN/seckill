package cn.whu.trade.service;

import cn.whu.bo.OrderBO;

/**
 * @author snow
 * @className OrderService
 * @date 2021/6/29
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderBO
     */
    void createOrder(OrderBO orderBO, String transactionId);
}
