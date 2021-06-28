package cn.whu.user.controller;

import cn.whu.BaseController;
import cn.whu.bo.LoginBO;
import cn.whu.enums.STATUS;
import cn.whu.enums.UserStatus;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.bo.UpdateUserInfoBO;
import cn.whu.pojo.TUser;
import cn.whu.user.UserControllerApi;
import cn.whu.user.service.UserService;
import cn.whu.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;


/**
 * @author snow
 * @className UserController
 * @date 2021/6/27
 **/
@RestController
public class UserController extends BaseController implements UserControllerApi {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;


    @GetMapping("/hello")
    public GraceJsonResult hello(){
        return GraceJsonResult.ok();
    }

    @Override
    public GraceJsonResult getUserInfo(HttpServletRequest request) {
        String userId = getCookie(request, "uid");
        String key = redisOperator.getKey(REDIS_USER_INFO + ":" + userId);

        String userInfo = redisOperator.getKey(key);
        TUser user = JsonUtils.jsonToPojo(userInfo, TUser.class);
        return GraceJsonResult.ok(user);
    }

    @Override
    public GraceJsonResult updateUserInfo(@Valid UpdateUserInfoBO userInfoBO) {
        return null;
    }

    @Override
    public GraceJsonResult doLogin(@Valid LoginBO loginBO, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()){
            Map<String, String> errors = getErrors(bindingResult);
            return GraceJsonResult.errorMap(errors);
        }

        String email = loginBO.getEmail();

        TUser user = userService.queryUserByEmail(email);
        if (user != null && !user.getActiveStatus().equals(UserStatus.NOT_ACTIVE.getStatus())){
            return GraceJsonResult.errorCustom(STATUS.FROZEN_USER);
        } else if(user == null){
            return GraceJsonResult.errorCustom(STATUS.NOT_FOUND_USER);
        }
        // 登录成功
        String uToken = UUID.randomUUID().toString();
        redisOperator.set(REDIS_USER_TOKEN + ":" + user.getUserId(), uToken);
        redisOperator.set(REDIS_USER_INFO + ":" + user.getUserId(), JsonUtils.objectToJson(user));

        setCookie(request, response, "utoken", uToken, COOKIE_MONTH);
        setCookie(request, response, "uid", user.getUserId(), COOKIE_MONTH);

        return GraceJsonResult.ok();
    }

}
