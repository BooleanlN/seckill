package cn.whu.user.dubbo;

import cn.whu.bo.UserBO;
import cn.whu.dubbo.BaseDubboService;
import cn.whu.dubbo.user.UserDubboService;
import cn.whu.enums.STATUS;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TUser;
import cn.whu.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author snow
 * @className UserServiceImpl
 * @date 2021/7/4
 **/
@Service
public class UserDubboServiceImpl extends BaseDubboService implements UserDubboService{
    @Resource
    UserService userService;

    @Override
    public GraceJsonResult addUser(UserBO userBO) {
        String email = userBO.getEmail();
        String nickName = userBO.getNikename();
        TUser user = userService.queryUserByEmailAndNickName(email, nickName);
        if (user != null){
            return GraceJsonResult.errorCustom(STATUS.USER_DUPLICATED_FAIL);
        }
        user = userService.createUser(userBO);

        return GraceJsonResult.ok(user);
    }
}
