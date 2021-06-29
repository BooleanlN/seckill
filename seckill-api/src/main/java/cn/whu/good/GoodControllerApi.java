package cn.whu.good;

import cn.whu.bo.GoodBO;
import cn.whu.bo.StockBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "查询库存",httpMethod = "GET")
    @GetMapping("/stock")
    GraceJsonResult getStock(@RequestBody @Valid GoodBO goodBO);

    @ApiOperation(value = "获取商品列表",httpMethod = "GET")
    @GetMapping("/getGoodList")
    GraceJsonResult queryGoodList(@ApiParam(name = "page", value = "查询下一页的第几页",required = false)
                                  @RequestParam Integer page,
                                  @ApiParam(name = "pageSize", value = "分页查询每一页显示的条数", required = false)
                                  @RequestParam Integer pageSize);
}
