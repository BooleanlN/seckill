package cn.whu.activity.service;

import cn.whu.bo.TokenBO;

/**
 * @author snow
 * @className ActivityService
 * @date 2021/7/8
 **/
public interface ActivityService {
    /**
     * 生成秒杀令牌
     * @param tokenBO
     * @return
     */
    String generateSecondKillToken(TokenBO tokenBO);
}
