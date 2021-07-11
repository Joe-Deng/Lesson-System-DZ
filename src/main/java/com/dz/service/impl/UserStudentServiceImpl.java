package com.dz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dz.entity.UserStudent;
import com.dz.mapper.UserStudentMapper;
import com.dz.service.UserStudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生账号  服务实现类
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Service
public class UserStudentServiceImpl extends ServiceImpl<UserStudentMapper, UserStudent> implements UserStudentService {

}
