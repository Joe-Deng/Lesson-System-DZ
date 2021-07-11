package com.dz.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class TeacherSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 老师号
     */
    private String teacherId;

    /**
     * 课程号
     */
    private String lessonId;

    /**
     * 授课日程
     */
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
        return "TeacherSchedule{" +
        "id=" + id +
        ", teacherId=" + teacherId +
        ", lessonId=" + lessonId +
        ", schedule=" + schedule +
        "}";
    }
}
