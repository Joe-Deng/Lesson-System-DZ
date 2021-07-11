package com.dz.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dz.entity.Lesson;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public interface LessonMapper extends BaseMapper<Lesson> {
@Select("SELECT any_value(id),name,any_value(college_id) FROM lesson where name like '%${keyword}%'  GROUP BY name")
    public List<Lesson> matchLessons(@Param("keyword") String keyword);

@Select("SELECT * FROM LESSON WHERE NAME LIKE '%${keyword}%'")
    public List<Lesson> matchAllLessons(@Param("keyword") String keyword);
}
