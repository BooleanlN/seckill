package cn.whu.good.service.impl;

import cn.whu.bo.GoodBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.good.mapper.TGoodMapper;
import cn.whu.good.mapper.TStockMapper;
import cn.whu.good.service.GoodService;
import cn.whu.pojo.TGood;
import cn.whu.pojo.TStock;
import cn.whu.service.BaseService;
import cn.whu.utils.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
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

    @Resource
    TStockMapper stockMapper;

    @Resource
    Sid sid;
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
        goodExample.orderBy("goodName").desc();
        PageHelper.startPage(page,pageSize);
        List<TGood> goodList = goodMapper.selectByExample(goodExample);

        return setterPagedGrid(goodList,page);
    }

    /**
     * 创建新商品
     * 涉及多表更新，添加事务支持
     * @param good
     */
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void createGood(GoodBO good) {
        String goodId = sid.nextShort(); // 分布式Id
        String stockId = sid.nextShort();

        TGood tGood = new TGood();
        TStock tStock = new TStock();

        BeanUtils.copyProperties(good,tGood);

        tGood.setGoodId(goodId);
        tGood.setCreateTime(new Date());
        tGood.setUpdateTime(new Date());

        if (tGood.getGoodDesc() == null){ // 没有描述，则设置商品名
            tGood.setGoodDesc(good.getGoodName());
        }

        tStock.setGoodId(goodId);
        tStock.setStockCount(good.getGoodStock());
        tStock.setStockConsumeCount((long)0);
        tStock.setCreateTime(new Date());
        tStock.setUpdateTime(new Date());
        tStock.setStockId(stockId);

        int res = goodMapper.insert(tGood);
        int stockRes = stockMapper.insert(tStock);

        if (res != 1 || stockRes != 1){
            GraceException.display(STATUS.GOOD_CREATE_ERROR);
        }
    }
}
