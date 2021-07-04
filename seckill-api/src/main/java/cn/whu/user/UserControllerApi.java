package cn.whu.user;

import cn.whu.bo.LoginBO;
import cn.whu.bo.UpdateUserInfoBO;
import cn.whu.bo.UserBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    GraceJsonResult getUserInfo(HttpServletRequest request);

    @PostMapping("/updateUserInfo")
    GraceJsonResult updateUserInfo(@RequestBody @Valid UpdateUserInfoBO userInfoBO);

    @ApiOperation(value = "通过email获得用户信息",notes = "通过email获得用户信息",httpMethod = "POST")
    @PostMapping("/doLogin")
    GraceJsonResult doLogin(@RequestBody @Valid LoginBO loginBO, BindingResult bindingResult,
                            HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "创建新用户", notes = "创建新用户", httpMethod = "POST")
    @PostMapping("/doCreate")
    GraceJsonResult doCreate(@RequestBody @Valid UserBO userBO, BindingResult bindingResult,
                             HttpServletRequest request, HttpServletResponse response);
}
