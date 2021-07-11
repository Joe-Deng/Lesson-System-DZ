package com.dz.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dz.entity.Instruct;
import com.dz.entity.InstructInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 授课 Mapper 接口
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public interface InstructMapper extends BaseMapper<Instruct> {
    @Select("select i.class_id as class_id,\n" +
            "c.name as class_name,\n" +
            "i.lesson_id as lesson_id,\n" +
            "l.name as lesson_name,\n" +
            "i.teacher_id as teacher_id,\n" +
            "t.name as teacher_name,\n" +
            "i.schedule as schedule\n" +
            "from instruct i join class c join teacher t join lesson l\n" +
            "where i.class_ID = c.id and\n" +
            "i.lesson_id = l.id and\n" +
            "i.teacher_id = t.id and\n" +
            "i.class_id = #{classId}")
    public List<InstructInfo> getInstructInfosByClassId(@Param("classId") String classId);

    @Select("select i.class_id as class_id,\n" +
            "c.name as class_name,\n" +
            "i.lesson_id as lesson_id,\n" +
            "l.name as lesson_name,\n" +
            "i.teacher_id as teacher_id,\n" +
            "t.name as teacher_name,\n" +
            "i.schedule as schedule\n" +
            "from instruct i join class c join teacher t join lesson l\n" +
            "where i.class_ID = c.id and\n" +
            "i.lesson_id = l.id and\n" +
            "i.teacher_id = t.id and\n" +
            "i.class_id in \n" +
            "(select id from class where college_id= #{college_id})")
    public List<InstructInfo> getInstructInfosByCollegeId(@Param("college_id") String collegeId);

    @Select("select i.class_id as class_id,\n" +
            "c.name as class_name,\n" +
            "i.lesson_id as lesson_id,\n" +
            "l.name as lesson_name,\n" +
            "i.teacher_id as teacher_id,\n" +
            "t.name as teacher_name,\n" +
            "i.schedule as schedule\n" +
            "from instruct i join class c join teacher t join lesson l\n" +
            "where i.class_ID = c.id and\n" +
            "i.lesson_id = l.id and\n" +
            "i.teacher_id = t.id and\n" +
            "i.class_id in \n" +
            "(select id from class where lesson_id= #{lesson_id})")
    public List<InstructInfo> getInstructInfosByLessonId(@Param("lesson_id")String lessonId);

    @Select("select i.class_id as class_id,\n" +
            "c.name as class_name,\n" +
            "i.lesson_id as lesson_id,\n" +
            "l.name as lesson_name,\n" +
            "i.teacher_id as teacher_id,\n" +
            "t.name as teacher_name,\n" +
            "i.schedule as schedule\n" +
            "from instruct i join class c join teacher t join lesson l\n" +
            "where i.class_ID = c.id and\n" +
            "i.lesson_id = l.id and\n" +
            "i.teacher_id = t.id and\n" +
            "l.name = #{lesson_name} and  t.name=#{teacher_name} ")
    public List<InstructInfo> getInstructInfosByMap(@Param("lesson_name")String lesson_name,@Param("teacher_name")String teacher_name);
}
