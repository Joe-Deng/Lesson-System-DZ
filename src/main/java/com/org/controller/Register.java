package com.org.controller;

import com.dz.entity.Student;
import com.dz.entity.UserStudent;
import com.dz.mapper.StudentMapper;
import com.dz.service.UserStudentService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Register {
    @Resource
    UserStudentService userStudentService;
    @Resource
    StudentMapper studentMapper;

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username ==null || password== null){
            return "../../registerFail";
        }
        //如果已经登录
        if(request.getSession().getAttribute("username")!=null){
            response.sendRedirect("home");
            return null;
        }

        //检查数据库
        UserStudent student = userStudentService.selectById("username"); //查询用户名是否注册过
        Map<String,Object> map=new HashMap<>();
        map.put("id",username);
        List<Student> students = studentMapper.selectByMap(map);    //查询学号是否对应用户名
        if(students==null || students.size()==0){
            System.out.println("注册失败：用户名不对应学号");
            return "../../registerFail";
        }
        if(student!=null){
            //如果已经注册过
            return "../../registerFail";
        }else {
            boolean res = userStudentService.insert(new UserStudent(username, password));
            if(res){
                //成功则转发请求，让登录处理结果，这样可以记载Session
                request.getRequestDispatcher("login").forward(request, response);
                System.out.println("注册成功");
                return null;
            }else {
                System.out.println("注册失败");
                return "../../registerFail";
            }
        }
    }
}
