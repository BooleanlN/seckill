package cn.whu.trade.controller;

import cn.whu.BaseController;
import cn.whu.bo.NewOrderBO;
import cn.whu.bo.OrderBO;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.trade.DoOrderControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

/**
 * @author snow
 * @className DoOrderController
 * @date 2021/6/27
 **/
public class DoOrderController extends BaseController implements DoOrderControllerApi{

    final static Logger logger = LoggerFactory.getLogger(DoOrderController.class);
    /**
     * 创建订单->锁定库存成功？->创建支付消息放入延时队列
     *
     * @param orderBO
     * @return
     */
    @Override
    public GraceJsonResult createOrder(@Valid OrderBO orderBO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return GraceJsonResult.errorMap(getErrors(bindingResult));
        }
        logger.info("用户%s创建订单，商品为%s，商品数量%d，订单金额为%f",orderBO.getUserId(),
                orderBO.getGoodId(),orderBO.getGoodCount(),orderBO.getMoney());
        return null;
    }
}
