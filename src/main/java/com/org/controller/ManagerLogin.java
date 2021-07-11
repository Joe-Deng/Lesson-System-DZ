package com.org.controller;

import com.alibaba.fastjson.JSON;
import com.dz.entity.UserManager;
import com.dz.service.UserManagerService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerLogin {
    @Resource
    private UserManagerService userManagerService;
    @RequestMapping("/login")
    public String login(){
        return "managerLogin";
    }

    @RequestMapping("/loginCheck")
    public String toLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserManager userManager = userManagerService.selectById(username);
        if(userManager==null){
            System.out.println("Controller:登录失败,用户名不存在");
            return "managerLoginFail";
        }
        if(userManager.getPassword().equals(password)){
            request.getSession().setAttribute("token",username);
            System.out.println("管理员登录成功，正在跳转");
            request.getRequestDispatcher("manager").forward(request,response);
            return null;
        }else {
            System.out.println("Controller:登录失败，密码错误");
            return "managerLoginFail";
        }
    }

    @RequestMapping("/manager")
    public String toManaget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession()!=null ||request.getSession().getAttribute("token")!=null){
            request.getRequestDispatcher("/WEB-INF/jsp/manager.html").forward(request,response);
            return null;
        }
        return "managerLogin";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("token");
        return "managerLogin";
    }
}
