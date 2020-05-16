package com.andrew.interceptor;

import com.andrew.model.SessionUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class ManagerInterceptor implements HandlerInterceptor {

    private static final String MANAGER_ROLE = "管理员";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessionUser loginUser=(SessionUser)request.getSession().getAttribute("login");
        if(loginUser.getRole().equals(MANAGER_ROLE)){
            return true;
        }
        response.sendRedirect("/houseofthecoder/main.html?page=1");
        return false;
    }

}
