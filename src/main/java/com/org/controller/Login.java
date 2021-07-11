package com.org.controller;

import com.dz.entity.UserStudent;
import com.dz.service.UserStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class Login {
    @Resource
    UserStudentService userStudentService;

    @RequestMapping("/")
    public String toLogin(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("username")==null){
            System.out.println("跳转回登录页");
            return "../../login";
        }else {
            response.sendRedirect("home");
            return null;
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录验证中");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        //查询session 是否已经登录
        HttpSession session1 = request.getSession();
        String username1 = (String) session1.getAttribute("username");
        if (username1 == null){
            System.out.println("没有用户名");
        }else {
            System.out.println("有用户名："+username1);
            //如果登录过，就直接跳转到主页
//            response.sendRedirect("home");
            request.getRequestDispatcher("WEB-INF/jsp/student.html").forward(request,response);
            return null;
        }

        //连接数据库检查
        UserStudent student = userStudentService.selectById(username);
        if(student == null){
            return "../../fail";
        }else if(!student.getPassword().equals(password)){
            System.out.println("真实密码:"+student.getPassword());
            System.out.println("填写密码:"+password);
            return "../../fail";
        }else {
            request.getSession().setAttribute("username",username);
//            response.sendRedirect("home");
            request.getRequestDispatcher("WEB-INF/jsp/student.html").forward(request,response);
            return null;
        }
    }
}
