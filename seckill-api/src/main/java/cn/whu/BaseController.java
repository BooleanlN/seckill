package cn.whu;

import cn.whu.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author snow
 * @className BaseController
 * @date 2021/6/27
 **/
public class BaseController {
    @Autowired
    RedisOperator redisOperator;


}
