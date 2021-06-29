package cn.whu.good.service.impl;

import cn.whu.bo.GoodBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.good.mapper.TGoodMapper;
import cn.whu.good.service.GoodService;
import cn.whu.pojo.TGood;
import cn.whu.service.BaseService;
import cn.whu.utils.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
     *
     * @param good
     */
    @Override
    public void createGood(GoodBO good) {
        String goodId = sid.nextShort(); // 分布式Id

        TGood tGood = new TGood();
        BeanUtils.copyProperties(good,tGood);

        tGood.setGoodId(goodId);
        tGood.setCreateTime(new Date());
        tGood.setUpdateTime(new Date());

        if (tGood.getGoodDesc() == null){ // 没有描述，则设置商品名
            tGood.setGoodDesc(good.getGoodName());
        }
        int res = goodMapper.insert(tGood);
        if (res != 1){
            GraceException.display(STATUS.GOOD_CREATE_ERROR);
        }
    }
}
