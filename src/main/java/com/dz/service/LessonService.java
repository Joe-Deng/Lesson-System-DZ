package com.dz.service;

import com.baomidou.mybatisplus.service.IService;
import com.dz.entity.Lesson;

import java.util.List;


/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public interface LessonService extends IService<Lesson> {
    public List<Lesson> matchLessons(String keyword);
}
