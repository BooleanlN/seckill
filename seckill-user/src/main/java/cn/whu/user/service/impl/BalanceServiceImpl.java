package cn.whu.user.service.impl;

import cn.whu.bo.UpdateBalanceBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.pojo.TBalance;
import cn.whu.service.BaseService;
import cn.whu.user.mapper.TBalanceMapper;
import cn.whu.user.service.BalanceService;
import cn.whu.utils.RedisOperator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author snow
 * @className BalanceServiceImpl
 * @date 2021/7/1
 **/
@Service
public class BalanceServiceImpl extends BaseService implements BalanceService {

    @Resource
    TBalanceMapper balanceMapper;
    /**
     * 查询用户当前余额
     *
     * @param userId
     * @return
     */
    @Override
    public TBalance queryBalance(String userId) {
        Example example = new Example(TBalance.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        TBalance balance = balanceMapper.selectOneByExample(example);
        if (balance == null){
            GraceException.display(STATUS.NOT_FOUND_USER);
        }
        return balance;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBalance(UpdateBalanceBO updateBalanceBO) {
        // 延时双删
        String userId = updateBalanceBO.getUserId();
        String redisKey = REDIS_BALANCE_TOKEN + ":" + userId;
        String balanceIdKey = REDIS_BALANCE_ID_TOKEN + ":" + userId;
        String balanceId = redis.getKey(balanceIdKey);

        redis.delKey(redisKey);

        TBalance balance = new TBalance();
        balance.setUserId(userId);
        balance.setBalanceId(redis.getKey(balanceId));
        balance.setCreateTime(new Date());
        balance.setUpdateTime(new Date());

        int res = balanceMapper.updateByPrimaryKey(balance);
        if (res != 1){
            GraceException.display(STATUS.UPDATE_BALANCE_FAIL);
        }
        try {
            Thread.sleep(100);
            redis.delKey(redisKey);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
