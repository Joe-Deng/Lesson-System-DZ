package com.org.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}
