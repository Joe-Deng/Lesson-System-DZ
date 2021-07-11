package com.dz.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.dz.entity.Lesson;
import com.dz.mapper.LessonMapper;
import com.dz.service.LessonService;
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
 * 课程 前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/dz/lesson")
public class LessonController {
    @Resource
    private LessonService lessonService;
    @Resource
    private LessonMapper lessonMapper;
    @RequestMapping("/search")
    public String search(HttpServletRequest request, HttpServletResponse response){
        //分页参数
        int currentPage = 1;
        int limit = 20;
        if(request.getParameter("page")!=null){
            currentPage = Integer.valueOf(request.getParameter("page"));
        }
        if(request.getParameter("limit")!=null){
            limit = Integer.valueOf(request.getParameter("limit"));
        }
        String college_id = request.getParameter("college_id");
        Map<String,Object> map = new HashMap<>();
        if(college_id!=null) {
            map.put("college_id", college_id);
        }
        PageHelper.startPage(currentPage,limit);
        List<Lesson> lessons = lessonService.selectByMap(map);
        PageInfo<Lesson> pageInfos = new PageInfo<>(lessons);
        response.setHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString(pageInfos);
    }

    @RequestMapping("/match")
    public String match(HttpServletRequest request,HttpServletResponse response){
        String keyword = request.getParameter("keyword");
        String limit = request.getParameter("limit");
        if(keyword!=null){
            System.out.println(limit);
            PageHelper.startPage(1, Integer.parseInt(limit));
            List<Lesson> lessons = lessonMapper.matchLessons(keyword );
            PageInfo<Lesson> pageInfos = new PageInfo<>(lessons);
            return JSON.toJSONString(pageInfos);
        }else {
            return null;
        }
    }

    @RequestMapping("/search_name")
    public String searchByName(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        int currentPage = 1;
        int limit = 20;
        if(request.getParameter("page")!=null){
            currentPage = Integer.valueOf(request.getParameter("page"));
        }
        if(request.getParameter("limit")!=null){
            limit = Integer.valueOf(request.getParameter("limit"));
        }
        if(name!=null){
            PageHelper.startPage(currentPage,limit);
            List<Lesson> lessons = lessonMapper.matchAllLessons(name);
            PageInfo<Lesson> pageInfos = new PageInfo<>(lessons);
            return JSON.toJSONString(pageInfos);
        }else {
            return null;
        }
    }
}

