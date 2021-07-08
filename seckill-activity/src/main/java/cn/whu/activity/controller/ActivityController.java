package cn.whu.activity.controller;

import cn.whu.BaseController;
import cn.whu.activity.ActivityControllerApi;
import cn.whu.activity.service.ActivityService;
import cn.whu.bo.TokenBO;
import cn.whu.grace.result.GraceJsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author snow
 * @className ActivityController
 * @date 2021/7/8
 **/
@RestController
public class ActivityController extends BaseController implements ActivityControllerApi {

    @Resource
    ActivityService activityService;

    @Override
    public GraceJsonResult generateToken(@Valid TokenBO tokenBO, BindingResult bindingResult,
                                         HttpServletRequest request) {
        String uid = getCookie(request, "uid");
        tokenBO.setUserId(uid);
        String token = activityService.generateSecondKillToken(tokenBO);
        return GraceJsonResult.ok(token);
    }
}
