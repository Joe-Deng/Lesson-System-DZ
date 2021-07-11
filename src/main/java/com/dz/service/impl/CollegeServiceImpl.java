package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.College;
import com.dz.mapper.CollegeMapper;
import com.dz.service.CollegeService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 学院 服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {

}
