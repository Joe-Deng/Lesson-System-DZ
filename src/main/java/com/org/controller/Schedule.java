package com.org.controller;

import com.alibaba.fastjson.JSON;
import com.dz.entity.InstructInfo;
import com.dz.entity.Student;
import com.dz.mapper.InstructMapper;
import com.dz.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class Schedule {
@Resource
private StudentService studentService;
@Resource
private InstructMapper instructMapper;

    @RequestMapping("get")
    public String getSchedule(HttpServletRequest request, HttpServletResponse response){
        //想要获取（InstructInfo.id,InstructInfo.className,InstructInfo.teacherName)
//        String studentId = (String) request.getSession().getAttribute("username");
        String studentId = request.getParameter("username");
        System.out.println("当前请求课程表数据的学生是："+studentId);
        if(studentId == null || studentId.isEmpty()){
            return null;
        }
        //1.查询该同学所在班级
        Student student = studentService.selectById(studentId);
        if(student==null) return null;  //如果没查到该学生说明是通过其他渠道访问的链接
        String classId = student.getClassId();
        //2.根据班级Id查询课程
        List<InstructInfo> instructInfos = instructMapper.getInstructInfosByClassId(classId);
        return JSON.toJSONString(instructInfos);
    }
}
