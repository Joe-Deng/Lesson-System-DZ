package com.dz.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 教师
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所在学院
     */
    @TableField("COLLEGE_ID")
    private String collegeId;

    /**
     * 教师编号
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 性别
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;


    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "collegeId=" + collegeId +
        ", id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", age=" + age +
        "}";
    }
}
