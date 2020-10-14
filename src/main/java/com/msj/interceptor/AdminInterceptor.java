package com.msj.interceptor;

import com.msj.base.SystemInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/16 10:51
 * @desc 后端拦截器
 */
public class AdminInterceptor extends SystemInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        获取请求地址
        String path = request.getRequestURI();
        if (path.contains("img") || path.contains("js") || path.contains("css") || path.contains("login") || path.contains("logOut")) {
            return true;
        }
//        判断登录状态
        Object admin = request.getSession().getAttribute("admin");
        if (Objects.nonNull(admin) && !String.valueOf(admin).trim().isEmpty()) {
            return true;
        }
        response.sendRedirect("/admin/login");
        return false;
    }
}
