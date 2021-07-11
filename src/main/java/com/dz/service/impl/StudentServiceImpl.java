package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.Student;
import com.dz.mapper.StudentMapper;
import com.dz.service.StudentService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
