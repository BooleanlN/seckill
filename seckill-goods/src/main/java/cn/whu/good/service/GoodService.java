package cn.whu.good.service;

import cn.whu.bo.GoodBO;
import cn.whu.pojo.TGood;
import cn.whu.utils.PagedGridResult;

import java.util.List;

/**
 * @author snow
 * @className GoodService
 * @date 2021/6/28
 **/
public interface GoodService {
    /**
     * 请求商品列表页
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryGoodList(Integer page, Integer pageSize);

    /**
     * 创建新商品
     * @param good
     */
    void createGood(GoodBO good);
}
