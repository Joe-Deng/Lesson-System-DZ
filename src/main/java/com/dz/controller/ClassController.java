package com.dz.controller;


import com.alibaba.fastjson.JSON;
import com.dz.entity.Class;
import com.dz.service.ClassService;
import org.mybatis.spring.annotation.MapperScan;
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
 * 班级 前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */

@RestController
@RequestMapping("/dz/class")
public class ClassController {
    @Resource
    ClassService classService;
    @RequestMapping("/hello")
    public String hello(){
        return "Hello,World";
    }

    @RequestMapping("/get")
    public String getByMap(HttpServletRequest request, HttpServletResponse response){
        String collegeId = request.getParameter("college_id");
        String result = "";
        if(!collegeId.isEmpty()){
            Map<String,Object> map = new HashMap<>();
            map.put("college_id",collegeId);
            List<Class> classes = classService.selectByMap(map);
            result = JSON.toJSONString(classes);
            response.setHeader("Access-Control-Allow-Origin","*");
        }else {
            result = JSON.toJSONString(classService.selectList(null));
        }
        return result;
    }
}

