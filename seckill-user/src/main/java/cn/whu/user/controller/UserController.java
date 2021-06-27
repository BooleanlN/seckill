package cn.whu.user.controller;

import cn.whu.grace.result.GraceJsonResult;
import cn.whu.bo.UpdateUserInfoBO;
import cn.whu.user.UserControllerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author snow
 * @className UserController
 * @date 2021/6/27
 **/
@RestController
public class UserController implements UserControllerApi {

    @GetMapping("/hello")
    public GraceJsonResult hello(){
        return GraceJsonResult.ok();
    }

    @Override
    public GraceJsonResult getUserInfo(String userId) {
        return null;
    }

    @Override
    public GraceJsonResult updateUserInfo(@Valid UpdateUserInfoBO userInfoBO) {
        return null;
    }
}
