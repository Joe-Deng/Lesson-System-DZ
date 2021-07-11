package com.org.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截前=====");
        //判断Session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("拦截器session:"+username);

        //如果有session就放行
        if(session.getAttribute("username")!=null){
            if(username.equals("sadd") || username.equals("xiaoba")){
                //黑名单
                request.getRequestDispatcher("WEB-INF/jsp/ban.jsp").forward(request,response);
                return false;
            }
            System.out.println("已经登录，放行："+username);
            return true;
        }

        //登录页放行
        if(request.getRequestURI().contains("login")){
            System.out.println("当前是登录相关页，放行");
            return true;
        }

        //注册页放行
        if(request.getRequestURI().contains("register") || request.getRequestURI().contains("Register")){
            System.out.println("当前是注册相关页，放行");
            return true;
        }
//        if(token_ps!=null && token_us!=null){
//            System.out.println("token_us:"+token_us.getValue());
//            System.out.println("token_ps:"+token_ps.getValue());
//            //说明登录过
//            response.sendRedirect("home");
//        }else {
//            response.sendRedirect("login.jsp");
//        }
        System.out.println("休想通过！回去登录!");
        request.getRequestDispatcher("login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
