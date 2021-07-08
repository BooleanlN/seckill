package cn.whu.activity;

import cn.whu.bo.TokenBO;
import cn.whu.grace.result.GraceJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author snow
 * @className ActivityControllerApi
 * @date 2021/7/8
 **/
@Api(value = "活动接口", tags = {"活动相关"})
@RequestMapping("/activity")
public interface ActivityControllerApi {
    /**
     * 构建令牌
     * @param tokenBO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "获取令牌",httpMethod = "POST")
    @PostMapping("/generateToken")
    public GraceJsonResult generateToken(@RequestBody @Valid TokenBO tokenBO, BindingResult bindingResult,
                                         HttpServletRequest request);
}
