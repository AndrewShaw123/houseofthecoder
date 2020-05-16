package com.andrew.interceptor;

import com.andrew.model.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class UserInterceptor implements HandlerInterceptor {

    private static final String USER_ROLE = "用户";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SessionUser loginUser=(SessionUser)request.getSession().getAttribute("login");
        if(loginUser.getRole().equals(USER_ROLE)){
            return true;
        }
        response.sendRedirect("/houseofthecoder/managerpage/managermain.html?page=1");
        return false;

    }
}
