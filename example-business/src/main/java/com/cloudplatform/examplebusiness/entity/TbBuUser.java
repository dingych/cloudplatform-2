package com.cloudplatform.examplebusiness.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbBuUser)实体类
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
public class TbBuUser implements Serializable {
    private static final long serialVersionUID = -27953693979589826L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private Date createTime;
    
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}