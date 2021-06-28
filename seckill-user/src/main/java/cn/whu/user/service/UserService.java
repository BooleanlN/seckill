package cn.whu.user.service;

import cn.whu.pojo.TUser;

/**
 * @author snow
 * @className UserService
 * @date 2021/6/28
 **/
public interface UserService {
    /**
     * 判断用户是否存在，如果存在返回user信息
     * @param email
     * @return
     */
    TUser queryUserByEmail(String email);
}
