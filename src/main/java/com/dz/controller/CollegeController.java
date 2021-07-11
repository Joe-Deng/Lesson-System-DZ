package com.dz.controller;


import com.alibaba.fastjson.JSON;
import com.dz.entity.College;
import com.dz.service.CollegeService;
import com.dz.service.impl.CollegeServiceImpl;
import com.dz.mapper.CollegeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 学院 前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@MapperScan("com.dz.mapper")
@RestController
@RequestMapping("/dz/college")
public class CollegeController {
    @Resource
    private CollegeMapper collegeMapper;
//    private CollegeService service;
    @RequestMapping("/get_all")
    public String getAllCollegeInfo(HttpServletRequest request){

        List<College> colleges = collegeMapper.selectList(null);
        String json = JSON.toJSONString(colleges);
        System.out.println(json);
        return json;
    }
}

