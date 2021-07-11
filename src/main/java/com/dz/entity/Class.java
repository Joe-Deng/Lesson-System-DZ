package com.dz.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 班级
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所在学院
     */
    @TableField("COLLEGE_ID")
    private String collegeId;

    /**
     * 所属专业
     */
    @TableField("MAJOR_ID")
    private String majorId;

    /**
     * 班级ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 班级名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 班级年级
     */
    @TableField("GRADE")
    private Integer grade;


    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Class{" +
        "collegeId=" + collegeId +
        ", majorId=" + majorId +
        ", id=" + id +
        ", name=" + name +
        ", grade=" + grade +
        "}";
    }
}
