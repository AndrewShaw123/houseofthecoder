package com.andrew.interceptor;

import com.andrew.model.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SessionUser loginUser=(SessionUser)request.getSession().getAttribute("login");
        if(loginUser==null){
            logger.info("没有登录");
            response.sendRedirect("/houseofthecoder/sign_in.html");
            return false;
        }
        return true;
    }

}
