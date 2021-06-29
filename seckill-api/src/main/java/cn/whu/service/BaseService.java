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
    public static final String REDIS_ALL_CATEGORY = "redis_all_category";

    public static final String REDIS_WRITER_FANS_COUNTS = "redis_writer_fans_counts";
    public static final String REDIS_MY_FOLLOW_COUNTS = "redis_my_follow_counts";

    public static final String REDIS_ARTICLE_COMMENT_COUNTS = "redis_article_comment_counts";

    @Resource
    public RedisOperator redis;

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
