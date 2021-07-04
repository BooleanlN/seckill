package cn.whu.good.service;

import cn.whu.bo.GoodStockBO;
import cn.whu.pojo.TStock;

/**
 * @author snow
 * @className StorageService
 * @date 2021/6/29
 **/
public interface StorageService {
    /**
     * 查询库存信息，采用三级缓存，提高库存信息的查询速度（针对热点商品）
     * @param goodId
     * @return
     */
    TStock queryStorage(String goodId);

    /**
     * 减库存
     * @param goodStockBO
     */
    void reduceStorage(GoodStockBO goodStockBO);
}
