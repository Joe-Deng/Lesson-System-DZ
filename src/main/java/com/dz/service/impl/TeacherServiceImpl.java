package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.Teacher;
import com.dz.mapper.TeacherMapper;
import com.dz.service.TeacherService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
