package cn.whu.good;

import cn.whu.bo.GoodBO;
import cn.whu.bo.StockBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author snow
 * @className GoodController
 * @date 2021/6/28
 **/
@Api(value = "商品相关接口")
@RequestMapping("/good")
public interface GoodControllerApi {
    /**
     * 扣减库存
     * @param stockBO
     * @return
     */
    @ApiOperation(value = "扣减库存",httpMethod = "POST")
    @PostMapping("/reduce")
    GraceJsonResult reduceGood(@RequestBody @Valid StockBO stockBO);

    /**
     * 查询当前库存
     * @param goodBO
     * @return
     */
    @ApiOperation(value = "查询库存",httpMethod = "Get")
    @GetMapping("/stock")
    GraceJsonResult getStock(@RequestBody @Valid GoodBO goodBO);
}
