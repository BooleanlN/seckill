package cn.whu.user.service;

import cn.whu.bo.UpdateBalanceBO;
import cn.whu.pojo.TBalance;

/**
 * @author snow
 * @className BalanceService
 * @date 2021/7/1
 **/
public interface BalanceService {
    /**
     * 查询用户当前余额
     * @param userId
     * @return
     */
    TBalance queryBalance(String userId);

    /**
     * 更新当前余额
     * @param updateBalanceBO
     */
    void updateBalance(UpdateBalanceBO updateBalanceBO);
}
