package cn.whu.dubbo.good;

import cn.whu.bo.GoodStockBO;
import cn.whu.grace.result.GraceJsonResult;

/**
 * @author snow
 * @className GoodDubboService
 * @date 2021/7/4
 **/
public interface GoodDubboService {
    /**
     * εεεΊε­
     * @param goodStockBO
     * @return
     */
    GraceJsonResult reduceStock(GoodStockBO goodStockBO);
}
