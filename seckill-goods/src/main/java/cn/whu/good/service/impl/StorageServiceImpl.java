package cn.whu.good.service.impl;

import cn.whu.bo.GoodStockBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.good.mapper.StorageCustomMapper;
import cn.whu.good.mapper.TStockMapper;
import cn.whu.good.service.StorageService;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TStock;
import cn.whu.service.BaseService;
import cn.whu.utils.JsonUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author snow
 * @className StorageServiceImpl
 * @date 2021/6/29
 **/
@Service
public class StorageServiceImpl extends BaseService implements StorageService {
    
    @Resource
    TStockMapper stockMapper;

    @Resource
    StorageCustomMapper storageCustomMapper;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public TStock queryStorage(String goodId) {
        String storageKey = REDIS_STORAGE_COUNT + ":" + goodId;
        String storageLocalKey = LOCAL_STORAGE_COUNT + ":" + goodId;
        TStock stock = null;
        if (redis.isKeyExist(storageKey)){
            String storage = redis.getKey(storageKey);
            stock = JsonUtils.jsonToPojo(storage, TStock.class);

        } else {
            Example example = new Example(TStock.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("goodId",goodId);
            stock = stockMapper.selectOneByExample(example);
            redis.set(storageKey, JsonUtils.objectToJson(stock));
        }
        return stock;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public void reduceStorage(GoodStockBO goodStockBO) {
        long consumeCount = goodStockBO.getStockCount();
        String goodId = goodStockBO.getGoodId();
        String storageKey = REDIS_STORAGE_COUNT + ":" + goodId;
        if (redis.isKeyExist(storageKey)) {
            long result = redis.decrement(storageKey,consumeCount);
            if (result < 0){
                // 削减失败，将库存加回去
                redis.increment(storageKey,consumeCount);
                GraceException.display(STATUS.UPDATE_STORAGE_FAIL);
            } else {
                rocketMQTemplate.convertAndSend();
            }
        } else {
            int res = storageCustomMapper.decreaseStock(goodId,consumeCount);
            if (res != 1){
                GraceException.display(STATUS.UPDATE_STORAGE_FAIL);
            }
        }
    }
}
