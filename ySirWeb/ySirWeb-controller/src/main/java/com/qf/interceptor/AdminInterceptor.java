package com.qf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-27 00:41
 **/
public class AdminInterceptor implements HandlerInterceptor {
    /**
     * @Description: controller方法执行前进行过滤
     * @Param: [request, response, handler]
     * @return: boolean true放行，执行下一个拦截器，如果没有，执行controller中的方法；false，不放行。
     * @Author: Roue
     * @Date: 2020/6/27
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("过滤器执行");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        if (null == userName || "".equals(userName)) {
            response.sendRedirect("/ySirWeb/admin/loginView");//要写全路径名称
            return false;
        }
        return true;
    }

}

