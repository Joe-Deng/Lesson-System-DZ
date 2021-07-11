package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.Lesson;
import com.dz.mapper.LessonMapper;
import com.dz.service.LessonService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson> implements LessonService {
    @Resource
    LessonMapper lessonMapper;
public List<Lesson> matchLessons(String keyword){
    List<Lesson> lessons = lessonMapper.matchLessons(keyword);
    return lessons;
}
}
