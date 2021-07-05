package cn.whu.user.dubbo;

import cn.whu.bo.UpdateBalanceBO;
import cn.whu.dubbo.user.BalanceDubboService;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.user.service.BalanceService;

import javax.annotation.Resource;

/**
 * @author snow
 * @className BalanceDubboServiceImpl
 * @date 2021/7/4
 **/
public class BalanceDubboServiceImpl implements BalanceDubboService {
    @Resource
    BalanceService balanceService;
    /**
     * 金额更新
     *
     * @param balanceBO
     * @return
     */
    @Override
    public GraceJsonResult reduceBalance(UpdateBalanceBO balanceBO) {
        balanceService.updateBalance(balanceBO);
        return GraceJsonResult.ok();
    }
}
