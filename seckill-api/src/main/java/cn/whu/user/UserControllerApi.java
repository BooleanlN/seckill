package cn.whu.user;

import cn.whu.bo.UpdateUserInfoBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author snow
 * @className UserControllerApi
 * @date 2021/6/27
 **/
@Api(value = "用户信息相关Controller",tags = {"用户相关"})
@RequestMapping("/user")
public interface UserControllerApi {

    @ApiOperation(value = "获得用户信息",notes = "获得用户信息",httpMethod = "POST")
    @PostMapping("/getUserInfo")
    GraceJsonResult getUserInfo(@RequestParam String userId);

    @PostMapping("/updateUserInfo")
    GraceJsonResult updateUserInfo(@RequestBody @Valid UpdateUserInfoBO userInfoBO);
}
