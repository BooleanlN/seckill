package cn.whu.good.service.impl;

import cn.whu.bo.GoodStockBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.good.mapper.TStockMapper;
import cn.whu.good.service.StorageService;
import cn.whu.pojo.TStock;
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
public class StorageServiceImpl implements StorageService {
    
    @Resource
    TStockMapper stockMapper;


    @Override
    public TStock queryStorage(String goodId) {
        Example example = new Example(TStock.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("goodId",goodId);
        TStock stock = stockMapper.selectOneByExample(criteria);
        return stock;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public void reduceStorage(GoodStockBO goodStockBO) {
        Example example = new Example(TStock.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("goodId",goodStockBO.getGoodId());
        TStock stock = stockMapper.selectOneByExample(example);

        long currentTotal = stock.getStockCount();
        long currentConsume = stock.getStockConsumeCount();
        if(currentTotal < goodStockBO.getStockCount()){
            GraceException.display(STATUS.STOCK_NOT_ENOUGH);
        }
        currentTotal -= stock.getStockCount();
        currentConsume += stock.getStockCount();

        stock.setStockConsumeCount(currentConsume);
        stock.setStockCount(currentTotal);
        stock.setUpdateTime(new Date());

        int res = stockMapper.updateByPrimaryKey(stock);
        if (res != 1){
            GraceException.display(STATUS.STOCK_REDUCE_FAIL);
        }
    }
}
