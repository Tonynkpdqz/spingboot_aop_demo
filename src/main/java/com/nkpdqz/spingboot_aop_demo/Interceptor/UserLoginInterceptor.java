package com.nkpdqz.spingboot_aop_demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flg = false;
        //此处省略验证token合法性
        String token = request.getHeader("token");
        if (token!=null && !token.isEmpty())
            flg = true;
        else {
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/aop/login");
            //response.getWriter().write("no right!");
        }
        return flg;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
