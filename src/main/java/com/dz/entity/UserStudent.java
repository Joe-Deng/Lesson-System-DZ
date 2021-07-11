package com.dz.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 学生账号 
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
public class UserStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名 用户名，对应学号
     */
    @TableId(value = "username", type = IdType.ID_WORKER)
    private String username;

    /**
     * 密码
     */
    private String password;

    public UserStudent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserStudent{" +
        "username=" + username +
        ", password=" + password +
        "}";
    }
}
