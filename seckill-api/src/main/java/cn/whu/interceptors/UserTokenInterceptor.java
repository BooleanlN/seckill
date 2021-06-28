package cn.whu.interceptors;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author snow
 * @className UserTokenInterceptor
 * @date 2021/6/28
 **/
public class UserTokenInterceptor extends BaseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uToken = getCookie(request,"uToken");
        String uUid = getCookie(request, "uid");

        boolean verifyFlag = verifyUserIdToken(uUid, uToken, REDIS_USER_TOKEN);

        return true;
    }
}
