package com.zhss.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UserLoginInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
                             throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Boolean login = Boolean.valueOf(request.getParameter("_login"));
        System.out.println(login);
        return true ;
    }
    
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler, 
                           ModelAndView moodelAndView)
                           throws Exception {
    
    }
    
    public void afterCompletion(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Object handler, 
                                Exception ex)
                                throws Exception {
    
    }
    
}
