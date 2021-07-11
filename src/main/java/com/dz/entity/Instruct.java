package com.dz.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 授课
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class Instruct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程号
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 任课老师
     */
    @TableField("TEACHER_ID")
    private String teacherId;

    /**
     * 任课班级
     */
    @TableField("CLASS_ID")
    private String classId;

    /**
     * 教授课程
     */
    @TableField("LESSON_ID")
    private String lessonId;

    /**
     * 开课日程
     */
    @TableField("SCHEDULE")
    private Integer schedule;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Instruct{" +
        "id=" + id +
        ", teacherId=" + teacherId +
        ", classId=" + classId +
        ", lessonId=" + lessonId +
        ", schedule=" + schedule +
        "}";
    }
}
