package cn.whu.good;

import cn.whu.bo.GoodStockBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author snow
 * @className StorageControllerApi
 * @date 2021/6/30
 **/
@Api(value = "库存接口")
@RequestMapping("/storage")
public interface StorageControllerApi {
    @ApiOperation(value = "获取库存", httpMethod = "GET")
    @GetMapping("/getStock")
    GraceJsonResult queryStock(@RequestParam String goodId);

    @ApiOperation(value = "削减库存", httpMethod = "POST")
    @GetMapping("/reduceStock")
    GraceJsonResult reduceStock(@RequestBody @Valid GoodStockBO goodStockBO, BindingResult bindingResult);
}
