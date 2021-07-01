package cn.whu.good.service;

import cn.whu.bo.GoodStockBO;
import cn.whu.pojo.TStock;

/**
 * @author snow
 * @className StorageService
 * @date 2021/6/29
 **/
public interface StorageService {
    TStock queryStorage(String goodId);

    void reduceStorage(GoodStockBO goodStockBO);
}
