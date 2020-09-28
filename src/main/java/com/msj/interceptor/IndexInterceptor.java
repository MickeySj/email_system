package com.msj.interceptor;

import com.msj.base.SystemInterceptor;
import com.msj.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 22:20
 */
public class IndexInterceptor extends SystemInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String path = request.getRequestURI();
        Object user = session.getAttribute("user");
        if (path.contains("/index/cart") || path.contains("/index/order") || path.contains("/cart/cartBuy")) {
            if (!Objects.nonNull(user)) {
                response.sendRedirect("/index/login");
                return false;
            }
        }
        return true;
    }
}
