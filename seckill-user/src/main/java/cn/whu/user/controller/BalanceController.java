package cn.whu.user.controller;

import cn.whu.BaseController;
import cn.whu.bo.BalanceBO;
import cn.whu.bo.UpdateBalanceBO;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TBalance;
import cn.whu.user.BalanceControllerApi;
import cn.whu.user.service.BalanceService;
import cn.whu.user.service.UserService;
import cn.whu.utils.JsonUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author snow
 * @className BalanceController
 * @date 2021/7/1
 **/
@RestController
public class BalanceController extends BaseController implements BalanceControllerApi {
    @Resource
    BalanceService balanceService;

    @Override
    public GraceJsonResult reduceBalance(@Valid UpdateBalanceBO balanceBO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return GraceJsonResult.errorMap(getErrors(bindingResult));
        }
        balanceService.updateBalance(balanceBO);
        return GraceJsonResult.ok();
    }

    @Override
    public GraceJsonResult queryBalance(HttpServletRequest request) {
        String userId = getCookie(request,"uid");
        String redisKey = REDIS_BALANCE_TOKEN + ":" + userId;
        TBalance balance = null;
        if (redisOperator.isKeyExist(redisKey)){
            String balanceInfo = redisOperator.getKey(redisKey);
            balance = JsonUtils.jsonToPojo(balanceInfo, TBalance.class);
        } else {
            balance = balanceService.queryBalance(userId);
            redisOperator.set(redisKey, JsonUtils.objectToJson(balance));
            redisOperator.set(REDIS_BALANCE_ID_TOKEN + ":" + userId, balance.getBalanceId());
        }
        return GraceJsonResult.ok(balance);
    }
}
