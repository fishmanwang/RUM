package com.rum.service.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Liuweibo
 * @version Id: UserListVO.java, v0.1 2017/11/21 Liuweibo Exp $$
 */
public class UserListVO {

    private Long   id;

    private String username;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date   gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date   gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
