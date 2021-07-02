package com.example.shop.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 判断当前用户是否存在，存在返回true,不存在重定向到 /login 方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("userId") == null) {
            response.sendRedirect("/login");
        }
        return true;
    }
}
