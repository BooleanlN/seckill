package cn.whu.user.service.impl;

import cn.whu.pojo.TUser;
import cn.whu.user.mapper.TUserMapper;
import cn.whu.user.service.UserService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author snow
 * @className UserServiceImpl
 * @date 2021/6/28
 **/
public class UserServiceImpl implements UserService {

    @Resource
    TUserMapper mapper;
    /**
     * 判断用户是否存在，如果存在返回user信息
     *
     * @param email
     * @return
     */
    @Override
    public TUser queryUserByEmail(String email) {
        Example userExample = new Example(TUser.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("email",email);
        TUser user = mapper.selectOneByExample(criteria);
        return user;
    }
}
