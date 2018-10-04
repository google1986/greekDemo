package com.htzw.study.service;

/**
* @Description:    用户接口层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
public interface UserService {
    /**
     * 根据用户名称和密码验证用户信息
     * @param userName 用户名称
     * @param password 密码
     * @return 是否登陆成功
     */
    boolean login(String userName, String password);
}
