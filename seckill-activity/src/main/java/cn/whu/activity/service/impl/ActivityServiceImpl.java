package cn.whu.activity.service.impl;

import cn.whu.activity.mapper.TActivityMapper;
import cn.whu.activity.service.ActivityService;
import cn.whu.bo.TokenBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.pojo.TActivity;
import cn.whu.service.BaseService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author snow
 * @className ActivityServiceImpl
 * @date 2021/7/8
 **/
@Service
public class ActivityServiceImpl extends BaseService implements ActivityService {

    @Resource
    TActivityMapper mapper;
    /**
     * 生成秒杀令牌
     *
     * @param tokenBO
     * @return
     */
    @Override
    public String generateSecondKillToken(TokenBO tokenBO) {
        String activityId = tokenBO.getActivityId();
        Example activityExample = new Example(TActivity.class);
        Example.Criteria criteria = activityExample.createCriteria();
        criteria.andEqualTo("activityId",activityId);

        TActivity activity = mapper.selectOneByExample(activityExample);

        if (activity == null){
            GraceException.display(STATUS.ACTVITY_NOT_FOUND);
        }
        Integer status = 0;
        // 查看活动是否开启
        if (activity.getActivityBeginTime().after(new Date())) {
            GraceException.display(STATUS.ACTVITY_NOT_LAUNCH);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        redis.set(REDIS_VERIFY_TOKEN + ":"+activityId + ":" + tokenBO.getUserId()
                + ":" + tokenBO.getGoodId(),token,1600);
        return token;
    }
}
