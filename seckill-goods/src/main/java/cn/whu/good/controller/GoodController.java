package cn.whu.good.controller;

import cn.whu.bo.GoodBO;
import cn.whu.bo.StockBO;
import cn.whu.good.GoodControllerApi;
import cn.whu.grace.result.GraceJsonResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author snow
 * @className GoodController
 * @date 2021/6/28
 **/
@RestController
public class GoodController implements GoodControllerApi {
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
     * @param goodBO
     * @return
     */
    @Override
    public GraceJsonResult getStock(@Valid GoodBO goodBO) {
        return null;
    }
}
