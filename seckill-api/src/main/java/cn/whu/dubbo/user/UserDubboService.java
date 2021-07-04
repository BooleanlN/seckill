package cn.whu.dubbo.user;

import cn.whu.bo.LoginBO;
import cn.whu.bo.UserBO;
import cn.whu.grace.result.GraceJsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author snow
 * @className UserService
 * @date 2021/7/4
 **/
public interface UserDubboService {
    /**
     * 添加用户
     * @param userBO
     * @return
     */
    GraceJsonResult addUser(UserBO userBO);
}
