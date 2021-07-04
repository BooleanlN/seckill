package cn.whu.user;

import cn.whu.bo.BalanceBO;
import cn.whu.bo.UpdateBalanceBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author snow
 * @className BalanceControllerApi
 * @date 2021/7/1
 **/
@Api(value = "用户余额信息相关Controller",tags = {"用户相关"})
@RequestMapping("/balance")
public interface BalanceControllerApi {
    @ApiOperation(value = "扣除余额", notes = "扣除余额", httpMethod = "POST")
    @PostMapping("/reduce")
    GraceJsonResult reduceBalance(@RequestBody @Valid UpdateBalanceBO balanceBO, BindingResult bindingResult);

    @ApiOperation(value = "查询余额", notes = "查询余额", httpMethod = "GET")
    @GetMapping("/query")
    GraceJsonResult queryBalance(HttpServletRequest request);
}
