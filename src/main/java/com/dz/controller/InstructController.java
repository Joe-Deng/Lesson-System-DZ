package com.dz.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.dz.entity.Instruct;
import com.dz.entity.InstructInfo;
import com.dz.entity.Lesson;
import com.dz.entity.Student;
import com.dz.mapper.InstructMapper;
import com.dz.service.InstructService;
import com.dz.service.StudentService;
import com.dz.service.impl.InstructServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 授课 前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/dz/instruct")
public class InstructController {
    @Resource
    InstructServiceImpl instructService;
    @Resource
    InstructMapper instructMapper;
    @Resource
    StudentService studentService;

    @RequestMapping("/search")
    public String search(HttpServletRequest request){
        String collegeId= request.getParameter("college_id");
        String classId = request.getParameter("class_id");
        //分页参数
        int currentPage = 1;
        int limit = 20;
        if(request.getParameter("page")!=null){
            currentPage = Integer.valueOf(request.getParameter("page"));
        }
        if(request.getParameter("limit")!=null){
            limit = Integer.valueOf(request.getParameter("limit"));
        }
        System.out.println("search:"+collegeId+","+classId);
        Map<String,Object> map=new HashMap<>();
        if(collegeId==null || collegeId.isEmpty()){
            //以学院为单位查询，如果没指定学院ID则返回空，而不是返回所有数据
            return null;
        }
        if(classId==null || classId.isEmpty()){
            System.out.println("根据collegeID查询");
            PageHelper.startPage(currentPage,limit);
            List<InstructInfo> instructInfos = instructMapper.getInstructInfosByCollegeId(collegeId);
            PageInfo<InstructInfo> pageInfos = new PageInfo<>(instructInfos);
//            instructsByCollegeId.forEach(System.out::println);
            return JSON.toJSONString(pageInfos);
        }
        map.put("class_id",classId);
        PageHelper.startPage(currentPage,limit);
        List<InstructInfo> instructInfos = instructMapper.getInstructInfosByClassId(classId);
        PageInfo<InstructInfo> pageInfos = new PageInfo<>(instructInfos);
        return JSON.toJSONString(pageInfos);
    }

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        String lessonId = request.getParameter("lesson_id");
        if(lessonId == null) return null;
        List<InstructInfo> instructInfos = instructMapper.getInstructInfosByLessonId(lessonId);
        return JSON.toJSONString(instructInfos);
    }

    @RequestMapping("/search2")
    public String Search2(HttpServletRequest request){
        String lesson_name = request.getParameter("lesson_name");
        String teacher_name = request.getParameter("teacher_name");
//        HashMap<Object, Object> map = new HashMap<>();
        if(lesson_name==null || lesson_name.isEmpty()){
            return null;
        }
        if(teacher_name==null || teacher_name.isEmpty()){
            return null;
        }
        List<InstructInfo> instructInfos = instructMapper.getInstructInfosByMap(lesson_name, teacher_name);
        return JSON.toJSONString(instructInfos);
    }

    @RequestMapping("/delete")
    public String deleteInstruct(HttpServletRequest request,HttpServletResponse response){
        String class_id = request.getParameter("class_id");
        String lesson_id = request.getParameter("lesson_id");
        if(class_id == null || class_id.isEmpty()){
            return null;
        }
        if(lesson_id==null || lesson_id.isEmpty()){
            return null;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("class_id",class_id);
        map.put("lesson_id",lesson_id);
        boolean res = instructService.deleteByMap(map);
        System.out.println("删除结果："+res);
        if(res){
            return "success";
        }else {
            return null;
        }
    }

    @RequestMapping("/add")
    public String addInstruct(HttpServletRequest request){
        String teacher_id = request.getParameter("teacher_id");
        String schedule = request.getParameter("schedule");
        String username = request.getParameter("username");
        System.out.println(teacher_id);
        System.out.println(schedule);
        System.out.println(username);
        if(teacher_id==null||teacher_id.isEmpty()){
            return null;
        }
        if(schedule==null||schedule.isEmpty()){
            return null;
        }
        if(username==null||username.isEmpty()){
            return null;
        }
        //现根据学生查询班级
        Student student = studentService.selectById(username);
        String classId = student.getClassId();
        //查询
        Map<String,Object> map = new HashMap<>();
        map.put("teacher_id",teacher_id);
        map.put("schedule",Integer.valueOf(schedule));
        Wrapper<Instruct> instructEntityWrapper = new EntityWrapper<>();
        instructEntityWrapper.eq("teacher_id",teacher_id);
        instructEntityWrapper.eq("schedule",Integer.valueOf(schedule));
        List<Instruct> instructs = instructService.selectByMap(map);
        Instruct instruct = instructs.get(0);
        instruct.setClassId(classId);
        //更新
        boolean updateRes = instructService.update(instruct,instructEntityWrapper);
        System.out.println("更新结果："+updateRes);
        if(updateRes){
            return "success";
        }
        return null;
    }
}

