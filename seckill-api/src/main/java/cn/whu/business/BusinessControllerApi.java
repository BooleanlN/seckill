package cn.whu.business;

import cn.whu.bo.BuyBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author snow
 * @className BusinessControllerApi
 * @date 2021/6/27
 **/
@Api(value = "业务行为接口", tags = {"业务相关"})
@RequestMapping("/buiness")
public interface BusinessControllerApi {
    /**
     * 购买商品业务入口
     * @param buyBO
     * @return
     */
    @ApiOperation(value = "购买商品",httpMethod = "POST")
    @PostMapping("/buy")
    GraceJsonResult handleBuy(@RequestBody @Valid BuyBO buyBO);
}
