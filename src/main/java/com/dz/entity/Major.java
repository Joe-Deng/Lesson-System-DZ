package com.dz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 专业
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 专业名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 所属学院ID
     */
    @TableField("COLLEGE_ID")
    private String collegeId;


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

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return "Major{" +
        "id=" + id +
        ", name=" + name +
        ", collegeId=" + collegeId +
        "}";
    }
}
