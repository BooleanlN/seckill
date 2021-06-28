package cn.whu.interceptors;

import cn.whu.enums.STATUS;
import cn.whu.exception.GraceException;
import cn.whu.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author snow
 * @className BaseInterceptor
 * @date 2021/6/28
 **/
public class BaseInterceptor{
    @Resource
    public RedisOperator redis;

    public static final String REDIS_USER_TOKEN = "redis_user_token";
    public static final String REDIS_USER_INFO = "redis_user_info";
    public static final String REDIS_ADMIN_TOKEN = "redis_admin_token";

    public boolean verifyUserIdToken(String id,
                                     String token,
                                     String redisKeyPrefix) {

        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(token)) {
            String redisToken = redis.getKey(redisKeyPrefix + ":" + id);
            if (StringUtils.isBlank(id)) {
                GraceException.display(STATUS.UN_LOGIN);
                return false;
            } else {
                // 检查token是否一致
                if (!redisToken.equalsIgnoreCase(token)) {
                    GraceException.display(STATUS.TICKET_INVALID);
                    return false;
                }
            }
        } else {
            GraceException.display(STATUS.UN_LOGIN);
            return false;
        }

        return true;
    }

    // 从cookie中取值
    public String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(key)){
                String value = cookie.getValue();
                return value;
            }
        }
        return null;
    }

}
