package com.htzw.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @Description:    用户前台展示模型
* @Author:         glj
* eateDate:     2018/10/8 16:24
* @Version:        1.0
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable{
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 真实名称
     */
    private String trueName;
    /**
     * 机构编号
     */
    private Integer orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 登录密码
     */
    private String password;
}
