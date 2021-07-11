package com.dz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 所在学院
     */
    @TableField("COLLEGE_ID")
    private String collegeId;

    /**
     * 所在班级
     */
    @TableField("CLASS_ID")
    private String classId;

    /**
     * 学生姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 年级
     */
    @TableField("GRADE")
    private Integer grade;

    /**
     * 手机号
     */
    @TableField("MOBILE_PHONE")
    private String mobilePhone;

    /**
     * 性别
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", collegeId=" + collegeId +
        ", classId=" + classId +
        ", name=" + name +
        ", grade=" + grade +
        ", mobilePhone=" + mobilePhone +
        ", sex=" + sex +
        ", avatar=" + avatar +
        "}";
    }
}
