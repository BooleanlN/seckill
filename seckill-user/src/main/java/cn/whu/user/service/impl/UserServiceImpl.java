package cn.whu.user.service.impl;

import cn.whu.bo.UserBO;
import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.pojo.TUser;
import cn.whu.user.mapper.TUserMapper;
import cn.whu.user.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author snow
 * @className UserServiceImpl
 * @date 2021/6/28
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    TUserMapper mapper;

    @Resource
    Sid sid;
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
        TUser user = mapper.selectOneByExample(userExample);
        return user;
    }

    /**
     * 创建用户
     *
     * @param userBO
     */
    @Override
    public TUser createUser(UserBO userBO) {
        TUser user = new TUser();

        String userId = sid.nextShort();
        BeanUtils.copyProperties(userBO, user);

        if (user.getSex() == null){
            user.setSex(0);
        }
        user.setUserId(userId);
        user.setActiveStatus(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int res = mapper.insert(user);
        if (res != 1){
            GraceException.display(STATUS.USER_CREATE_FAIL);
        }
        return user;
    }

    /**
     * 判断用户是否存在，如果存在返回user信息
     *
     * @param email
     * @param nickName
     * @return
     */
    @Override
    public TUser queryUserByEmailAndNickName(String email, String nickName) {
        Example userExample = new Example(TUser.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("email",email).andEqualTo("nikename",nickName);
        return mapper.selectOneByExample(userExample);
    }
}
