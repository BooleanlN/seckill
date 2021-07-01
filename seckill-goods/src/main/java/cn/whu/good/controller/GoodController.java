package cn.whu.good.controller;

import cn.whu.BaseController;
import cn.whu.bo.GoodBO;
import cn.whu.bo.StockBO;
import cn.whu.good.GoodControllerApi;
import cn.whu.good.service.GoodService;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.utils.PagedGridResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author snow
 * @className GoodController
 * @date 2021/6/28
 **/
@RestController
public class GoodController extends BaseController implements GoodControllerApi {

    final static Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Resource
    GoodService goodService;
    /**
     * 扣减库存
     *
     * @param stockBO
     * @return
     */
    @Override
    public GraceJsonResult reduceGood(@Valid StockBO stockBO) {
        return null;
    }

    /**
     * 查询当前库存
     *
     * @param goodId
     * @return
     */
    @Override
    public GraceJsonResult getStock(String goodId) {
        return null;
    }

    @Override
    public GraceJsonResult queryGoodList(Integer page, Integer pageSize) {
        if (page == null) {
            page = COMMON_START_PAGE;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }
        PagedGridResult result = goodService.queryGoodList(page, pageSize);
        return GraceJsonResult.ok(result);
    }

    @Override
    public GraceJsonResult createGood(@Valid GoodBO goodBO, BindingResult result) {
        if (result.hasErrors()){
            return GraceJsonResult.errorMap(getErrors(result));
        }
        goodService.createGood(goodBO);
        return GraceJsonResult.ok();
    }
}
