package cn.whu.good.dubbo;

import cn.whu.bo.GoodStockBO;
import cn.whu.dubbo.good.GoodDubboService;
import cn.whu.good.service.GoodService;
import cn.whu.good.service.StorageService;
import cn.whu.grace.result.GraceJsonResult;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author snow
 * @className GoodDubboServiceImpl
 * @date 2021/7/4
 **/
@Service
public class GoodDubboServiceImpl implements GoodDubboService {

    @Resource
    StorageService storageService;
    /**
     * 削减库存
     *
     * @param goodStockBO
     * @return
     */
    @Override
    public GraceJsonResult reduceStock(GoodStockBO goodStockBO) {
        storageService.reduceStorage(goodStockBO);
        return GraceJsonResult.ok();
    }
}
