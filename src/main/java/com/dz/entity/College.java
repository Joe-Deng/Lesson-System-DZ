package com.dz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 学院
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private String id;

    /**
     * 学院名称
     */
    @TableField("NAME")
    private String name;


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

    @Override
    public String toString() {
        return "College{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
