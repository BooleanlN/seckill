package cn.whu.good.service.impl;

import cn.whu.good.mapper.TGoodMapper;
import cn.whu.good.service.GoodService;
import cn.whu.pojo.TGood;
import cn.whu.service.BaseService;
import cn.whu.utils.PagedGridResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author snow
 * @className GoodServiceImpl
 * @date 2021/6/28
 **/
@Service
public class GoodServiceImpl extends BaseService implements GoodService {

    @Resource
    TGoodMapper goodMapper;
    /**
     * 请求商品列表页
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult queryGoodList(Integer page, Integer pageSize) {
        Example goodExample = new Example(TGood.class);
        // 默认以商品名排序
        goodExample.orderBy("good_name");
        PageHelper.startPage(page,pageSize);
        List<TGood> goodList = goodMapper.selectByExample(goodExample);

        return setterPagedGrid(goodList,page);
    }
}
