package cn.whu.dubbo.user;

import cn.whu.bo.UpdateBalanceBO;
import cn.whu.grace.result.GraceJsonResult;

/**
 * @author snow
 * @className BalanceDubboService
 * @date 2021/7/4
 **/
public interface BalanceDubboService {
    /**
     * 金额更新
     * @param balanceBO
     * @return
     */
    public GraceJsonResult reduceBalance(UpdateBalanceBO balanceBO);
}
