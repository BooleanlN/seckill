package cn.whu.business.controller;

import cn.whu.BaseController;
import cn.whu.bo.BuyBO;
import cn.whu.bo.OrderBO;
import cn.whu.bo.UserBO;
import cn.whu.business.BusinessControllerApi;
import cn.whu.business.mq.TransactionProducer;
import cn.whu.dubbo.user.UserDubboService;
import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TUser;
import cn.whu.utils.JsonUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author snow
 * @className BuinessController
 * @date 2021/6/27
 **/
@RestController
public class BusinessController extends BaseController implements BusinessControllerApi {
    final static Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Reference
    UserDubboService userDubboService;

    @Resource
    TransactionProducer producer;

    @Resource
    Sid sid;
    /**
     * 购买商品业务入口
     *
     * @param buyBO
     * @return
     */
    @Override
    public GraceJsonResult handleBuy(@Valid BuyBO buyBO) {
        //1. 扣减库存
        OrderBO orderBO = createOrder(buyBO);
        TransactionSendResult sendResult;
        try {
            // 发送事务消息
            sendResult = producer.send("order", JsonUtils.objectToJson(orderBO),
                    new HashMap<>());
        } catch (MQClientException e) {
            e.printStackTrace();
            return GraceJsonResult.errorCustom(STATUS.BUY_FAIL);
        }
        if(sendResult.getLocalTransactionState() == LocalTransactionState.ROLLBACK_MESSAGE){
            return GraceJsonResult.errorCustom(STATUS.BUY_FAIL);
        }else if(sendResult.getLocalTransactionState() == LocalTransactionState.COMMIT_MESSAGE){
            return GraceJsonResult.ok();
        }else{
            return GraceJsonResult.errorCustom(STATUS.BUY_FAIL);
        }
    }

    /**
     * 商品购买
     *
     * @param userBO
     * @return
     */
    @Override
    public GraceJsonResult register(@Valid UserBO userBO,
                                    BindingResult bindingResult,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
        logger.info(userBO.getNikename() + "用户创建中");
        if (bindingResult.hasErrors()){
            return GraceJsonResult.errorMap(getErrors(bindingResult));
        }
        GraceJsonResult result =  userDubboService.addUser(userBO);
        if (result.getCode() == 200){
            // 创建成功则登录
            String uToken = UUID.randomUUID().toString();
            TUser user = (TUser) result.getData();
            redisOperator.set(REDIS_USER_TOKEN + ":" + user.getUserId(), uToken);
            redisOperator.set(REDIS_USER_INFO + ":" + user.getUserId(), JsonUtils.objectToJson(user));

            setCookie(request, response, "utoken", uToken, COOKIE_MONTH);
            setCookie(request, response, "uid", user.getUserId(), COOKIE_MONTH);
        }
        return result;
    }
    public OrderBO createOrder(BuyBO buyBO){
        String tradeId = sid.nextShort();
        OrderBO orderBO = new OrderBO();
        orderBO.setTradeId(tradeId);
        orderBO.setGoodCount(buyBO.getGoodCount());
        orderBO.setMoney(buyBO.getMoney());
        orderBO.setUserId(buyBO.getUserId());
        orderBO.setGoodId(buyBO.getGoodId());
        return orderBO;
    }
}
