package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.Class;
import com.dz.mapper.ClassMapper;
import com.dz.service.ClassService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {
}
