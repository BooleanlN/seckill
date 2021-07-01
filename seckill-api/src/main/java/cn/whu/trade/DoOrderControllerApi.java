package cn.whu.trade;

import cn.whu.bo.NewOrderBO;
import cn.whu.bo.OrderBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author snow
 * @className DoOrderControllerApi
 * @date 2021/6/27
 **/
@Api(value = "订单操作相关接口",tags = {"订单相关"})
@RequestMapping(value = "order")
public interface DoOrderControllerApi {
    /**
     * 创建订单
     * @param orderBO
     * @return
     */
    @ApiOperation(value = "创建订单",httpMethod = "POST")
    @PostMapping("/createOrder")
    GraceJsonResult createOrder(@RequestBody @Valid OrderBO orderBO, BindingResult bindingResult);
}
