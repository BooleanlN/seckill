package cn.whu.service;

import cn.whu.utils.PagedGridResult;
import cn.whu.utils.RedisOperator;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author snow
 * @className BaseService
 * @date 2021/6/28
 **/
public class BaseService {

    public static final String COMMON_ACTIVITY = "NO_ACTIVITY";

    public static final String REDIS_BALANCE_TOKEN = "redis_balance_token";

    public static final String REDIS_BALANCE_ID_TOKEN = "redis_balance_id_token";

    public static final String REDIS_STORAGE_COUNT = "redis_storage";

    public static final String LOCAL_STORAGE_COUNT = "local_storage";

    public static final String REDIS_HOT_GOOD = "redis_hot_good";
    @Resource
    public RedisOperator redis;

    @Resource
    public CacheService cacheService;
    /**
     * 设置分页返回参数结果
     * @param list
     * @param page
     * @return
     */
    public PagedGridResult setterPagedGrid(List<?> list,
                                           Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult gridResult = new PagedGridResult();
        gridResult.setRows(list);
        gridResult.setPage(page);
        gridResult.setRecords(pageList.getTotal());
        gridResult.setTotal(pageList.getPages());
        return gridResult;
    }
}
