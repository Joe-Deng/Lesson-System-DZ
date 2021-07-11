package com.dz.controller;


import com.alibaba.fastjson.JSON;
import com.dz.entity.Student;
import com.dz.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/dz/student")
public class StudentController {
@Resource
    StudentService studentService;

@RequestMapping("/get")
    public String getInfo(HttpServletRequest request){
    String username = (String) request.getSession().getAttribute("username");
    if(username==null){
        username = request.getParameter("username");
    }
    System.out.println("————————————————————请求信息的ID————-");
    System.out.println(username);
    if(username!=null){
        Student student = studentService.selectById(username);
        if(student!=null){
            return JSON.toJSONString(student);
        }
    }
    return null;
    }
}

