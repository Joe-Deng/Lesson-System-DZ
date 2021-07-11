package com.org.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.pojo.Major;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//持久层
@Mapper
@Repository
public interface MajorMapper extends BaseMapper<Major> {
}
