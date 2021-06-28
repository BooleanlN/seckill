package cn.whu.business.controller;

import cn.whu.BaseController;
import cn.whu.bo.BuyBO;
import cn.whu.business.BusinessControllerApi;
import cn.whu.grace.result.GraceJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

/**
 * @author snow
 * @className BuinessController
 * @date 2021/6/27
 **/
public class BusinessController extends BaseController implements BusinessControllerApi {
    final static Logger logger = LoggerFactory.getLogger(BusinessController.class);
    /**
     * 购买商品业务入口
     *
     * @param buyBO
     * @return
     */
    @Override
    public GraceJsonResult handleBuy(@Valid BuyBO buyBO) {
        //1. 扣减库存

        //2. 创建订单
        return GraceJsonResult.ok();
    }
}
