package com.dz.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class ManagerLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 操作的管理员ID
     */
    private String managerId;

    /**
     * 记录内容
     */
    private String content;

    /**
     * 操作时间
     */
    private Date opDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    @Override
    public String toString() {
        return "ManagerLog{" +
        "id=" + id +
        ", managerId=" + managerId +
        ", content=" + content +
        ", opDate=" + opDate +
        "}";
    }
}
