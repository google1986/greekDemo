package com.htzw.study.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
* @Description:    用户信息model类
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable{
    private Integer userId;
    private String userName;
    private String trueName;
    private String roleType;
    private String password;
    private Integer orgId;
    private Integer status;
    private String updateDate;
    private String remark;
    private Organization org;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(String userName, String trueName, String password, Integer orgId, Integer status, String updateDate, String remark) {
        this.userName = userName;
        this.trueName = trueName;
        this.password = password;
        this.orgId = orgId;
        this.status = status;
        this.updateDate = updateDate;
        this.remark = remark;
    }
}