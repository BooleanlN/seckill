package cn.whu.trade.service.impl;

import cn.whu.pojo.TTradeLog;
import cn.whu.trade.mapper.TTradeLogMapper;
import cn.whu.trade.service.LogService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author snow
 * @className LogServiceImpl
 * @date 2021/7/5
 **/
public class LogServiceImpl implements LogService {

    @Resource
    TTradeLogMapper logMapper;
    /**
     * 根据事务ID查询流水
     *
     * @param transactionId
     * @return
     */
    @Override
    public TTradeLog queryLogByTransactionId(String transactionId) {
        Example example = new Example(TTradeLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("transactionId",transactionId);

        return logMapper.selectOneByExample(example);
    }
}
